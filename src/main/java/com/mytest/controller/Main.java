package com.mytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class Main {
    @RequestMapping("/")
    public String main() {
        System.out.println("test");
        return "forward:首页.html";
    }
}