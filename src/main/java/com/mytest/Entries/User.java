package com.mytest.Entries;


import lombok.Data;

import java.io.Serializable;

/**
 * user
 *
 * @author
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String name;
    private Integer officeId;
    private Integer roleId;
}