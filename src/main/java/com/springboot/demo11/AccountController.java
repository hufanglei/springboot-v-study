package com.springboot.demo11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 5.
 * 在springboot中使用freemarker的步骤
 * 1： 在pom.xml里面加入依赖
 *  <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-freemarker</artifactId>
 *         </dependency>
 *    2.默认的配置位置是 "classPath:/ftl/"
 *    3.看配置信息可以看源码: FreeMarkerProperties
 *    spring.freemarker.templateLoaderPath=classpath:/ftl/
 * spring.freemarker.suffix=.ftl
 *
 * 默认:
 * public static final String DEFAULT_SUFFIX = ".ftlh";
 *
 */
@Controller
public class AccountController {

    @RequestMapping("/reg")
    public String req(Model model){
        model.addAttribute("username", "root");
        return "reg";
    }
}
