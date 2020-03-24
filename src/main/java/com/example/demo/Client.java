package com.example.demo;

import bean.Response;
import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class Client {
    public static String BASE_URL ="http://127.0.0.1:8080";


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Response object = restTemplate.getForObject(BASE_URL + "/soa/product/1", Response.class);
        System.out.println(new Gson().toJson(object));
        String data = restTemplate.getForObject(BASE_URL + "/soa/product/1", String.class);
        System.out.println(data);
        System.out.println(new Gson().toJson(new Gson().fromJson(data, Response.class)));
        System.out.println(new Gson().toJson(new Gson().fromJson(data, Map.class).get("data")));
    }
}
