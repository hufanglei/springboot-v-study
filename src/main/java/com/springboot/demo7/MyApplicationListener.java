package com.springboot.demo7;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//监听器
@Component
public class MyApplicationListener implements ApplicationListener<MyAplicationEvent> {

    @Override
    public void onApplicationEvent(MyAplicationEvent event) {
        System.out.println("接受到事件============"+ event.getClass());
    }
}
