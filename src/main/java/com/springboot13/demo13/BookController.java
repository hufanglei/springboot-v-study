package com.springboot13.demo13;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class BookController {

//    @ExceptionHandler(value = FileNotFoundException.class)
//    @ExceptionHandler(value = Exception.class)
    public String error(Exception e){
        return " exception====  " + e.getMessage();
    }

    @GetMapping("/book/error1")
    public String list() throws FileNotFoundException {
        throw new FileNotFoundException("file not found");
    }

    @GetMapping("/book/error2")
    public String error2() throws ClassNotFoundException {
        throw new ClassNotFoundException("file not found");
    }

    @GetMapping("/user/null")
    public String empty() {
        throw new NullPointerException("args is empty");
    }
}
