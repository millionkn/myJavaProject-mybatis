package com.mytest.controller;

import com.mytest.Entries.User;
import com.mytest.dao.UserDao;
import com.mytest.permission.PermisssionUtils;
import com.mytest.permission.error.DuplicateEntries;
import com.mytest.permission.error.PasswordWrong;
import com.mytest.permission.error.UserNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("root")
public class Main {
    @Autowired
    PermisssionUtils utils;
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/login")
    @ResponseBody()
    public User loginIn(@RequestBody() LoginInfo info) throws UserNotExist, PasswordWrong, DuplicateEntries {
        return userDao.select(utils.loginIn(info.getUsername(), info.getPassword()));
    }

    @RequestMapping(value = "/loginOut")
    @ResponseBody()
    public String loginOut() {
        utils.loginOut();
        System.out.println("用户退出");
        return "";
    }

    @RequestMapping("/")
    public String main() {
        return "forward:index.html";
    }
}