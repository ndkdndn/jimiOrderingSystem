package com.example.orderingsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(){
        System.out.printf("helloworld");
        return "hello world";
    }
}
