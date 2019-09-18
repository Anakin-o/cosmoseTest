package com.didispace.service;

import com.didispace.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getReservationByUserId(String userId);

    void cancelReservation(Long reservationId);
}
