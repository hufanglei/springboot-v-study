package com.springboot13.demo13;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GloabalExceptinHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String errorHandler(Exception e){
       return "gloabal error  " + e.getClass().getName()+ " =="+ e.getMessage();
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public String errorHandler2(Exception e){
        return "gloabal error2  " + e.getClass().getName()+ " =="+ e.getMessage();
    }
}
