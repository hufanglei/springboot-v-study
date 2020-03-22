package com.springboot.demo12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 1.请求静态资源:
 *  1.放在webapp下 加resources.xml 可以访问到
 *   就可以直接访问到.
 *  2. 默认的静态资源的路径是:
 *  "classpath:/META-INF/resources/",
 * 			"classpath:/resources/",
 * 			"classpath:/static/",
 * 			"classpath:/public/" };
 * 3.可以通过spring.resources.static-locations 配置项修改默认静态资源路径
 *
 * 2.springboot如何使用servlet
 * @ServletComponentScan
 * @WebServlet("/user.do")
 *  方法一:(servlet3可以使用这种方法)
 *  1）编写servlet，然后加上响应的注解
 *  2）需要启用@ServletComonentScan注解
 *
 *  方法二:（servlet2.5及以下版本可以使用这种方法）
 *  1.填写servlet2
 *  2.装配相应的bean到spring容器中
 *  servlet -> ServletRegistrationBean
 *  fileter -》 FilterRegistrationBean
 *  listener -> ServletListenerRegistrationBean
 *
 */

//@ServletComponentScan
@SpringBootApplication
public class Demo12Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo12Application.class, args);
    }

}
