package com.springboot.demo7;

import org.springframework.context.ApplicationEvent;

//定义事件
public class MyAplicationEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    public MyAplicationEvent(Object source) {
        super(source);
    }
}
