package com.podinns.cqapi.mapper;

import com.podinns.cqapi.domain.HotelBase;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelBaseMapper {
    List<HotelBase> selectHotelBases(HotelBase record);
}