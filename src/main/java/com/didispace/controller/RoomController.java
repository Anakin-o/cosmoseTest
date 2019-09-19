package com.didispace.controller;

import com.didispace.entity.Room;
import com.didispace.model.RoomSearchCriteria;
import com.didispace.service.RoomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("room")
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @ApiOperation(value = "Search available room" ,  notes="Search available room")
    @ResponseBody
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public List<Room> search(@RequestBody RoomSearchCriteria roomSearchCriteria) {
        return roomService.getAvailableRoom(roomSearchCriteria);
    }

}