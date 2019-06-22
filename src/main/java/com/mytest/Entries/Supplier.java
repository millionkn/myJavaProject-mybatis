package com.mytest.Entries;

import lombok.Data;

import java.io.Serializable;

/**
 * supplier
 *
 * @author
 */
@Data
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String businessLicense;
    private String medicalDeviceBusinessLicense;
}