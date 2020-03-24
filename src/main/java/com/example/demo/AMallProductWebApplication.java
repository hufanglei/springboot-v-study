package com.example.demo;

import bean.Response;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;
import java.util.Collection;

/**
 * 服务发现，
 * 在进行服务调用的时候，需要先从注册中心获取到服务的地址，然后根据获取到的服务地址进行调用
 *
 */

//@SpringBootApplication
public class AMallProductWebApplication {

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
		list.forEach((instance) ->{
			System.out.println(instance.getAddress());
			System.out.println(instance.getPort());
			RestTemplate restTemplate = new RestTemplate();
			Response resp = restTemplate.getForObject("http://"+instance.getAddress() +":"+instance.getPort() + "/soa/product/1", Response.class);
			System.out.println(resp.getCode());
			System.out.println(resp.getMsg());
			System.out.println(resp.getData());
		});


	}

}
