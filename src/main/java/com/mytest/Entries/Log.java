package com.mytest.Entries;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * log
 *
 * @author
 */
@Data
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer personId;
    private BigInteger date;
    private Integer driverId;
    private String extra;
}