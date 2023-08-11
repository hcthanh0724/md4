package com.example.demospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/user")
    public String user(){
        return "day la user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "day la admin";
    }
}
