package com.springboot.demo12.demo;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

//@ServletComponentScan 不可以
@SpringBootConfiguration
public class ServletConfigration {

    @Bean
    public ServletListenerRegistrationBean createServletListenerRegistrationBean(){
        ServletListenerRegistrationBean listener = new ServletListenerRegistrationBean(new StartUpListener());
        return listener;
    }

    @Bean
    public FilterRegistrationBean createFilterRegistrationBean(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new EchoFilter());
        filter.setUrlPatterns(Arrays.asList("/book.do"));
        return filter;
    }


    @Bean
    public ServletRegistrationBean createBookServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new BookServlet(), "/book.do");
        return servletRegistrationBean;
    }






}
