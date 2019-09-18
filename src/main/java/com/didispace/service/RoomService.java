package com.didispace.service;

import com.didispace.entity.Room;
import com.didispace.model.RoomSearchCriteria;

import java.util.List;

public interface RoomService {
    List<Room> getAvailableRoom(RoomSearchCriteria roomSearchCriteria);
}
