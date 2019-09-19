package com.didispace.service.impl;

import com.didispace.entity.Reservation;
import com.didispace.model.Reserve;
import com.didispace.repository.ReservationRepository;
import com.didispace.repository.RoomRepository;
import com.didispace.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Reservation> getReservationByUserId(String userId) {
        return reservationRepository.findReservationByUserId(userId);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findOne(reservationId);
        reservation.setStatus(false);
        reservationRepository.save(reservation);
    }

    @Override
    public Reservation reserveRoom(Reserve reserve) {
        //validate first
        if (!validateRoom(reserve)) {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setReservationId((new Date().getTime()));
        reservation.setRoomId(reserve.getRoomId());
        reservation.setUserId(reserve.getUserId());
        reservation.setStatus(true);
        reservation.setStartTime(reserve.getStartTime());
        reservation.setEndTime(reserve.getEndTime());
        reservationRepository.save(reservation);
        return reservation;
    }

    /**
     * Check if a room has been reserved for a given time period,Also we can do more validation here if it is necessary.
     *
     * @param reserve
     * @return
     */
    private boolean validateRoom(Reserve reserve) {
        Integer result = roomRepository.validateRoom(reserve.getRoomId(), reserve.getStartTime(), reserve.getEndTime());
        return result == 0;
    }
}
