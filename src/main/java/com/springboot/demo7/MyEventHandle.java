package com.springboot.demo7;

import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
public class MyEventHandle {
    /*
     * 任意参数
     * 所有，该参数事件，或者其子事件都可以接收到
     * @param event  任意参数
     */
//    @EventListener
    public void onApplicationEvent(Object event) {
        System.out.println("接受到事件============"+ event.getClass());
    }

//    @EventListener
    public void event2(ContextStoppedEvent event) {
        System.out.println("应用停止事件============"+ event.getClass());
    }
}
