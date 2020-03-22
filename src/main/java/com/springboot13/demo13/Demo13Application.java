package com.springboot13.demo13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**一.
 * 拦截器的使用步骤
 *   1.写一个拦截器，实现HandlerInterceptor接口
 *   2.写一个类，继承WebMvcConfigurerAdapter抽象类，重写addInterceptors方法（已经过时）,并调用registry.addInterceptor把上一步的拦截器加进去
 *      实现WebMvcConfigurer接口，重写
 *
 * HandlerInterceptor
 * preHandle： controller执行之前调用
 * postHandle： controller执行之后，且页面渲染之前调用
 * afterCompletion： 页面渲染之后调用，一般用于资源清理操作
 *
 *
 *二、
  * 异常处理:
 * 如何去掉springboot 默认的异常处理逻辑
 * org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
 * 自定义错误处理页面：使用ErrorPageRegistrar的接口
 * 1.写一个类，实现ErrorPageRegistrar接口，实现registerErrorPages，在该方法里面，添加具体的错误处理逻辑
 * 2.全局异常处理步骤:
 * ---1.写一个类，需要加上@ControllerAdvice注解
 * ---2.写一个异常处理方法，需要加上@Exception（value=Exception.class）这个注解，在该方法上处理异常，
 *
 */
//@SpringBootApplication

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class Demo13Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo13Application.class, args);
    }

}
