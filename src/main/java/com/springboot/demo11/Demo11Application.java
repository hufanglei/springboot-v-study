package com.springboot.demo11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
// 1.案例1：最简单的启动小demo
//2.


//6.更换web容器
// springboot 容器默认使用的是tomcat作为外部容器
// 可以更换为jetty
// <dependency>
//            <groupId>org.springframework.boot</groupId>
//            <artifactId>spring-boot-starter-web</artifactId>
//           <!--  排除tomcat-->
//            <exclusions>
//                <exclusion>
//                    <groupId>org.springframework.boot</groupId>
//                    <artifactId>spring-boot-starter-tomcat</artifactId>
//                </exclusion>
//            </exclusions>
//        </dependency>
//<!--  加入jetty-->
//        <dependency>
//            <groupId>org.springframework.boot</groupId>
//            <artifactId>spring-boot-starter-jetty</artifactId>
//        </dependency>

@SpringBootApplication
public class Demo11Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Demo11Application.class, args);
    }

}
