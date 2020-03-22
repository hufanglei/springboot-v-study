package com.springboot.demo11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *   4.返回jsp页面
 *    需要另外加入 tomcat-embed-jasper的依赖
 *    然后在配置文件中，加入2个配置项
 *           spring.mvc.view.prefix=/WEB-INF/jsp/
 *           spring.mvc.view.suffix=.jsp
 *
 *           方法的返回值，是jsp的路径加文件名字
 *
 *
 *             <dependency>
 *             <groupId>org.apache.tomcat.embed</groupId>
 *             <artifactId>tomcat-embed-jasper</artifactId>
 * <!--            <version>9.0.27</version>-->
 *         </dependency>
 *
 *         <!--servlet依赖jar-->
 *         <dependency>
 *             <groupId>javax.servlet</groupId>
 *             <artifactId>javax.servlet-api</artifactId>
 *         </dependency>
 *
 *
 *         <!--Jstl标签依赖的jar包start-->
 *         <dependency>
 *             <groupId>javax.servlet</groupId>
 *             <artifactId>jstl</artifactId>
 *         </dependency>
 *
 *    给jsp页面传值：Model
 */
@Controller
public class LoginController {


    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if (username.equals(password)) {
            return "ok";
        }
        return "fail";
    }

    /**
     * 给jsp传参数，类似req.setAttribute
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String loginIndex(Model model){
        model.addAttribute("username", "root");
        return "login";
    }


}
