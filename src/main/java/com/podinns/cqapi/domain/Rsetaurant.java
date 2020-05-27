package com.podinns.cqapi.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Rsetaurant implements Serializable {
    private Long hotelId;

    private Date bizDate;

    private String taCode;

    private String taDescript;

    private BigDecimal charge;

    private String taRemark;

    private static final long serialVersionUID = 1L;

}