package com.mytest.Entries;

import lombok.Data;

import java.io.Serializable;

/**
 * office
 *
 * @author
 */
@Data
public class Office implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer personId;
}