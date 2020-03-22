package com.springboot.demo11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
// 4.3 新特性
// 1.RequestMapping
//2.传参数  @RequestParam 默认必填，可以设置非必填，和默认值
    //url方式 @PathVariable
    //java bean方式 不演示
//HttpServletRequest方式




@Controller
public class UserController {

    @RequestMapping(value = "/user/home",method= RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "user home";
    }

    @GetMapping("/user/home2")
    @ResponseBody
    public String home2(){
        return "user home2";
    }

    /**
     *  @RequestParam 注解默认是参数必须提供值
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/user/create")
    @ResponseBody
    public String create(@RequestParam(value = "username",defaultValue = "admin") String username, @RequestParam(value="password",required = false) String password){
        return "user create, username=" + username + ",password="+password;
    }

    /**
     * 获取url的方式/user/1 ，/user/2
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    @ResponseBody
    public String display(@PathVariable("id") String id){
        return "user display is=" + id;
    }

    @ResponseBody
    @GetMapping("/user/ip")
    public String edit(HttpServletRequest req){
        return "user edit " + req.getRemoteHost();
    }


}
