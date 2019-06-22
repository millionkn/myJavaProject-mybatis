package com.mytest.controller.restAPI;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class Base2<T> extends Base<T> {
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    void create(@RequestBody T object) {
        dao.create(object);
    }
}
