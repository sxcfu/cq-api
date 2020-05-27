package com.podinns.cqapi.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 */
@Data
public class RoomNo implements Serializable {
    private Long hotelId;

    private String code;

    private String rmDescript;

    private String floor;

    private String features;

    private String rmclass;

    private static final long serialVersionUID = 1L;

}