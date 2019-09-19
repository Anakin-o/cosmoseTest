package com.didispace.controller;

import com.didispace.entity.Reservation;
import com.didispace.model.Reserve;
import com.didispace.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("reservation")
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @ApiOperation(value = "Search Reservation by userId", notes = "Search Reservation by userId")
    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Reservation> search(String userId) {
        return reservationService.getReservationByUserId(userId);
    }

    @ApiOperation(value = "Cancel Reservation by reservationId", notes = "Cancel Reservation by reservationId")
    @RequestMapping(value = "/cancel")
    public void cancel(Long reservationId) {
        reservationService.cancelReservation(reservationId);
    }

    @ApiOperation(value = "reserve a room", notes = "reserve room")
    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public String reserve(@RequestBody Reserve reserve) {
        Reservation reservation = reservationService.reserveRoom(reserve);
        return reservation == null ? "Validation failed" : reservation.getReservationId().toString();
    }
}