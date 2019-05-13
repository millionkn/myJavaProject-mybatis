package com.mytest.controller;

import com.mytest.permission.PermisssionUtils;
import com.mytest.permission.ResourceAs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller("/")
public class Main {
    @Autowired
    PermisssionUtils utils;
    @RequestMapping("/")
    public String main() {
        return "forward:首页.html";
    }

    @RequestMapping(value = "/测试1", method = RequestMethod.POST)
    @ResponseBody()
    @ResourceAs("测试资源1")
    public String test1(@RequestParam Map<String, String> map, @RequestBody String body) {
        System.out.println("访问测试1");
        return "测试啊啊啊";
    }

    @RequestMapping(value = "/测试2", method = RequestMethod.POST)
    @ResponseBody()
    @ResourceAs("测试资源2")
    public String test2(@RequestParam Map<String, String> map, @RequestBody String body) {
        System.out.println("访问测试2");
        return "测试啊啊啊";
    }

    @RequestMapping(value = "/loginIn")
    @ResponseBody()
    public String loginIn() {
        try {
            utils.loginIn("user1", "password");
            System.out.println("用户登录");
            return "";
        } catch (Exception e) {
            return e.getClass().getName();
        }
    }

    @RequestMapping(value = "/loginOut")
    @ResponseBody()
    public String loginOut() {
        utils.loginOut();
        System.out.println("用户退出");
        return "";
    }
}