package com.didispace.repository;

import com.didispace.entity.Reservation;
import com.didispace.entity.Room;
import com.didispace.model.RoomSearchCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface ReservationRepository extends JpaRepository<Reservation, String> {
//    @Query("select reservation from Reservation where 1=1 and status=true and roomId=#{roomId} and ((startTime>=#{startTime} and endTime<=#{endTime}) or (startTime<=#{endTime} and endTime>=#{endTime}))")
//    List<Reservation> searchReservation(String roomId, Date startTime, Date endTime);

    @Query("select reservation from Reservation  reservation where reservation.userId=:userId")
    List<Reservation> findReservationByUserId(@Param("userId") String userId);

}
