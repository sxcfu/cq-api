package com.podinns.cqapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Reservation implements Serializable {
    private Long hotelId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bizDate;

    private String rmno;

    private String market;

    private String src;

    private String channel;

    private BigDecimal realRate;

    private String name;

    private String sex;

    private String idNo;

    private String mobile;

    private String street;

    private String sta;

    private String payCode;

    private static final long serialVersionUID = 1L;

}