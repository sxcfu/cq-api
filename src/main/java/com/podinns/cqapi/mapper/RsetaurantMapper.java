package com.podinns.cqapi.mapper;

import com.podinns.cqapi.domain.Rsetaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RsetaurantMapper {
    List<Rsetaurant> selectRsetaurants(Rsetaurant record);
}