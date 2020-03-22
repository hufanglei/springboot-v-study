package com.springboot.demo11;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 3.@RestController 表示当前controller的方法的返回值并可以直接用于body测试
 */
@RestController
public class RoleController {

    @RequestMapping(value = "/user1/home",method= RequestMethod.GET)
    public String home(){
        return "user home";
    }
}
