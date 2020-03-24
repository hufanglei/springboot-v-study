package com.springboot.amallproduct;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 服务注册
 */
@Component
public class ServiceRegister implements ApplicationRunner {
    @Value("${zookeeper.address}")
    private String zkAddress;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, new RetryOneTime(1000));
        client.start();
        client.blockUntilConnected();

        ServiceInstance<Object> instance = ServiceInstance.builder().name("product").address("192.168.157.1").port(8080).build();

        ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder
                                                    .builder(Object.class)
                                                    .client(client)
                                                    .basePath("/soa").build();

        serviceDiscovery.registerService(instance);
        serviceDiscovery.start();
        System.out.println("service register ok");
    }
}
