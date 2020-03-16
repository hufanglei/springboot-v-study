package com.springboot.demo7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListenerMethodProcessor;
/*
   入门案例:   1.自定义事件，一般是继承ApplicationEvent抽象类
               2.定义事件监听器，一般是实现ApplicationListener的接口
               3.启动时候，需要把监听器加入到spring容器中
               4.发布事件，使用ApplicationEventPublisher.publishEvent 发布事件

     配置监听器：
     1. SpringApplication..addListeners增加
     2. @Component 把监听器纳入到spring容器中管理
     3. application.properties中 context.listener.classes=com.springboot.demo7.MyApplicationListener
        使用 context.listener.classes配置该配置
        //原理: （详细内容参照  DelegatingApplicationListener） onApplicationEvent(getListeners) -- 执行过程
     4. MyEventHandle 使用注解 @EventListener，再发方法上面加入@EventListener注解，且该类需要纳入到spring容器中管理
     //EventListenerMethodProcessor afterSingletonsInstantiated processBean  selectMethods EventListenerFactory拼成
       一个listener，注入到context 	context.addApplicationListener(applicationListener);
 */

//      EventListenerMethodProcessor
////                DelegatingApplicationListener
@SpringBootApplication
public class Demo7Application {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Demo7Application.class);
        app.addListeners(new MyApplicationListener());
        ConfigurableApplicationContext context = app.run(args);
        context.publishEvent(new MyAplicationEvent(new Object()));
        context.close();
//        context.stop();
    }

}
