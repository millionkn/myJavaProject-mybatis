package com.mytest.controller;

import com.mytest.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class Main {
    @Autowired
    TestMapper testMapper;
    @RequestMapping("/")
    public String main() {
        System.out.println(testMapper.selectById(1).getValue());
        return "forward:首页.html";
    }
}