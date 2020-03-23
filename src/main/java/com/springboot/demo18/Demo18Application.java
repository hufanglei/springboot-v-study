package com.springboot.demo18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

//自定义starters
//@EnableRedis 方式

//@EnableRedis



/*
starter端
 * 自己开发一个spring boot starter的步骤
 *  1;新建一个项目
 *  2：需要一个配置类，配置类里面需要装配好需要提供出去的类
 *

   需要使用的端：
 *  导入jar包
 *
 *  3：
 * （1）使用@Enable，使用@Import需要转配的类
 * （2）\resources\META-INF\spring.factories，
 * 在org.springframework.boot.autoconfigure.EnableAutoConfiguration配置需要装配的类
 *
 *
 */
//@EnableRedis
@SpringBootApplication
public class Demo18Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Demo18Application.class, args);
        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis.getClient().getHost());
        System.out.println(jedis.getClient().getPort());
        jedis.set("id","123");
        System.out.println(jedis.get("id"));
//        context.close();
    }

}
