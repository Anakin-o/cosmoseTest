package com.didispace.service.impl;

import com.didispace.entity.Room;
import com.didispace.model.RoomSearchCriteria;
import com.didispace.repository.RoomRepository;
import com.didispace.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;


    @Override
    public List<Room> getAvailableRoom(RoomSearchCriteria roomSearchCriteria) {
        List<Room> roomList = roomRepository.searchAvailableRoom(roomSearchCriteria.getCity(), roomSearchCriteria.getMaxPrice(), roomSearchCriteria.getMinPrice(), roomSearchCriteria.getStartTime(), roomSearchCriteria.getEndTime());
        return roomList;
    }
}
