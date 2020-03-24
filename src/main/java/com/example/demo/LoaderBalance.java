package com.example.demo;

import java.util.List;

/**
 * 轮询器
 */
public class LoaderBalance {
    private int index = 0;
    private List<String> services;

    public LoaderBalance(List<String> services) {
        this.services = services;
    }

    public String choose(){
        String service = services.get(index);
        index++;
        if(index >= services.size()){
            index = 0;
        }
        return service;
    }

}
