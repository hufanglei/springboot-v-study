package com.springboot13.demo13;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/home")
    public String home(){
        return "user home";
    }

    @GetMapping("/user/help")
    public String help()  {
        throw new IllegalArgumentException("args is empty");
    }
}
