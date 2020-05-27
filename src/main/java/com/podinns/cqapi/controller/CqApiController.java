package com.podinns.cqapi.controller;

import com.podinns.cqapi.domain.*;
import com.podinns.cqapi.service.CqApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cqapi")
public class CqApiController {
    @Autowired
    private CqApiService cqApiBaseService;
//-- 基础门店信息
    @RequestMapping("/selectHotelBases")
    public AjaxResult selectHotelBases() {
        HotelBase record = new HotelBase();
        List<HotelBase> hotelBases = cqApiBaseService.selectHotelBases(record);
        return AjaxResult.success(hotelBases);
    }

//-- 预定信息
    @RequestMapping("/selectReservations")
    public AjaxResult selectReservations() {
        Reservation record = new Reservation();
        List<Reservation> hotelBases = cqApiBaseService.selectReservations(record);
        return AjaxResult.success(hotelBases);
    }

//-- 房号基础信息表
    @RequestMapping("/selectRoomNos")
    public AjaxResult selectRoomNos() {
        RoomNo record = new RoomNo();
        List<RoomNo> hotelBases = cqApiBaseService.selectRoomNos(record);
        return AjaxResult.success(hotelBases);
    }
//-- 餐费收入
    @RequestMapping("/selectRsetaurants")
    public AjaxResult selectRsetaurants() {
        Rsetaurant record = new Rsetaurant();
        List<Rsetaurant> hotelBases = cqApiBaseService.selectRsetaurants(record);
        return AjaxResult.success(hotelBases);
    }
}