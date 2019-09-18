package com.didispace.service.impl;

import com.didispace.entity.Reservation;
import com.didispace.repository.ReservationRepository;
import com.didispace.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getReservationByUserId(String userId) {
        return reservationRepository.findReservationByUserId(userId);
    }

    @Override
    public void cancelReservation(String reservationId) {
        Reservation reservation = reservationRepository.findOne(reservationId);
        reservation.setStatus(false);
        reservationRepository.save(reservation);
    }
}
