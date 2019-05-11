package com.mytest.controller;

import com.mytest.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller("/")
public class Main {
    @Autowired
    TestMapper testMapper;
    @RequestMapping("/")
    public String main() {
        System.out.println(testMapper.selectById(1).getValue());
        return "forward:首页.html";
    }

    @RequestMapping(value = "/测试",method = RequestMethod.POST)
    @ResponseBody()
    public String test(@RequestParam Map<String,String> map,@RequestBody String body) {
        return "测试啊啊啊";
    }
}