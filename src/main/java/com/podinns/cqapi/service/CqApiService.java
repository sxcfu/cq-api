package com.podinns.cqapi.service;

import com.podinns.cqapi.domain.HotelBase;
import com.podinns.cqapi.domain.Reservation;
import com.podinns.cqapi.domain.RoomNo;
import com.podinns.cqapi.domain.Rsetaurant;
import com.podinns.cqapi.mapper.HotelBaseMapper;
import com.podinns.cqapi.mapper.ReservationMapper;
import com.podinns.cqapi.mapper.RoomNoMapper;
import com.podinns.cqapi.mapper.RsetaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Name:${project_name}
 *
 * @Author : Lib
 * @Date: ${date}-${time}
 * @Description Copyright (c) ${year}, libao@podinns.com All Rights Reserved.
 */
@Service
public class CqApiService {
    @Autowired
    HotelBaseMapper hotelBaseMapper;
    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    RoomNoMapper roomNoMapper;
    @Autowired
    RsetaurantMapper rsetaurantMapper;

    public List<HotelBase> selectHotelBases(HotelBase record) {
        return hotelBaseMapper.selectHotelBases(record);
    }

    public List<Reservation> selectReservations(Reservation record) {
        return reservationMapper.selectReservations(record);
    }

    public List<RoomNo> selectRoomNos(RoomNo record) {
        return roomNoMapper.selectRoomNos(record);
    }

    public List<Rsetaurant> selectRsetaurants(Rsetaurant record) {
        return rsetaurantMapper.selectRsetaurants(record);
    }
}
