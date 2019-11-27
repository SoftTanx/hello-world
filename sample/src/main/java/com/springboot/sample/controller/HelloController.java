package com.springboot.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello.do")
    public String sayHello(){
        return "hello,spring-boot";
    }
}
