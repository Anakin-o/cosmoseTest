package com.didispace.controller;

import com.didispace.entity.Room;
import com.didispace.model.RoomSearchCriteria;
import com.didispace.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("room")
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @ResponseBody
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public List<Room> search(@RequestBody RoomSearchCriteria roomSearchCriteria) {
        return roomService.getAvailableRoom(roomSearchCriteria);
    }

}