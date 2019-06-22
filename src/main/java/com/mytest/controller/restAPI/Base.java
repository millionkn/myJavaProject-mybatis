package com.mytest.controller.restAPI;

import com.mytest.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class Base<T> {
    @Autowired
    BaseDao<T> dao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody()
    T[] getAll() {
        return dao.selectAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody()
    T get(@PathVariable("id") int id) {
        T obj = dao.select(id);
        if (obj == null) {
            int b = 0 / 0;
        }
        return obj;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    String delete(@PathVariable("id") int id) {
        dao.delete(id);
        return "";
    }
}
