package com.didispace.controller;

import com.didispace.entity.Reservation;
import com.didispace.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("reservation")
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Reservation> searchReservation(String userId) {
        return reservationService.getReservationByUserId(userId);
    }

    @RequestMapping(value = "/cancel")
    public void cancelReservation(Long reservationId) {
        reservationService.cancelReservation(reservationId);
    }

}