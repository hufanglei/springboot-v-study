package com.example.demo;

import bean.Response;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


//@SpringBootApplication
public class AppBanlance {

	public static String ZKADDRESS ="192.168.157.111:2181";



	public static void main(String[] args) throws Exception {
		CuratorFramework client = CuratorFrameworkFactory.newClient(ZKADDRESS, new RetryOneTime(1000));
		client.start();
		client.blockUntilConnected();

		ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder
				.builder(Object.class)
				.client(client)
				.basePath("/soa").build();

		Collection<ServiceInstance<Object>> list = serviceDiscovery.queryForInstances("product");

		final List<String> services = new ArrayList<>();

		list.forEach((instance) ->{
			services.add(instance.getAddress() + ":" + instance.getPort());

		});
		System.out.println(services);
		LoaderBalance lb = new LoaderBalance(services);
		for (int i=0;i<10;i++){
			RestTemplate restTemplate = new RestTemplate();
			Response resp = restTemplate.getForObject("http://"+lb.choose()+ "/soa/product/1", Response.class);
			System.out.println(resp.getCode());
			System.out.println(resp.getMsg());
			System.out.println(resp.getData());
		}
	}

}
