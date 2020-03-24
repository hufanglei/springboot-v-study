package com.springboot.amallproduct;
import com.springboot.amallproduct.bean.Product;
import com.springboot.amallproduct.mapper.ProductMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 演示：
 *    mysql+ mybatis的插入小demo
 *
 *   微服务的使用:
 *   注意，restTmplate的映射的最简单方式
 *    注意:
 *   格式化时间: 服务端格式化时间
 *   spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
 * spring.jackson.time-zone=GMT+8
 *                 注意map映射 create_time改成createTime
 *
 *==========================注册与发现==================================================
 *  常见的注册中心;
 *     zookeeoer consul etcd redis
 *
 *   服务器提供方，需要再服务器启动的时候，吧服务的信息（ip, port）注册到注册中心（zookeeper）
 *
 */



@SpringBootApplication
public class AMallProductApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AMallProductApplication.class, args);
        ProductMapper productMapper = context.getBean(ProductMapper.class);
//        Product product = new Product();
//        product.setPname("JAVA入门到精通");
//        product.setPrice(69.00);
//        product.setType("书籍");
//        product.setType("书籍");
//        productMapper.add(product);
//        context.close();
    }

}
