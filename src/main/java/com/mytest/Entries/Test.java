package com.mytest.Entries;

import java.io.Serializable;

/**
 * test
 *
 * @author
 */
public class Test implements Serializable {
    private Integer id;

    private String value;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}