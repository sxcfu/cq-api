package com.podinns.cqapi.mapper;

import com.podinns.cqapi.domain.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationMapper {
    List<Reservation> selectReservations(Reservation record);
}