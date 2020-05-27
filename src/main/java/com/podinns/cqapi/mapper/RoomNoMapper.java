package com.podinns.cqapi.mapper;

import com.podinns.cqapi.domain.RoomNo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomNoMapper {
    List<RoomNo> selectRoomNos(RoomNo record);
}