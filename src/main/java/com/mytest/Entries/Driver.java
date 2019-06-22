package com.mytest.Entries;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * driver
 *
 * @author
 */
@Data
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer officeId;
    private String name;
    private BigInteger buyDate;
    private Short inspectionTimes;
    private Short line;
    private String extra;
}