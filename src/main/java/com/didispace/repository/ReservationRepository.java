package com.didispace.repository;

import com.didispace.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select reservation from Reservation  reservation where reservation.userId=:userId")
    List<Reservation> findReservationByUserId(@Param("userId") String userId);

}
