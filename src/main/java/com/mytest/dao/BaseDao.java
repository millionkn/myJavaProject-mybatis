package com.mytest.dao;

public interface BaseDao<T> {
    T[] selectAll();

    T select(int id);

    void delete(int id);

    void update(int id, String key, String value);

    void create(T object);
}
