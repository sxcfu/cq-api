package com.podinns.cqapi.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class HotelBase implements Serializable {
    private Long id;

    private String code;

    private String descript;

    private String address1;

    private static final long serialVersionUID = 1L;
}