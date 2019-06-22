package com.mytest.Entries;

import lombok.Data;

import java.io.Serializable;

/**
 * role
 *
 * @author
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
}