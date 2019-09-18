package com.didispace.repository;

import com.didispace.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
public interface RoomRepository extends JpaRepository<Room, String> {
    @Query(value = "select room from Room room where room.city=:city " +
            "and room.price >= :minPrice and room.price<=:maxPrice" +
            " and not exists (select 1 from Reservation reservation where reservation.roomId=room.roomId and " +
            "(reservation.startTime >= :startTime and reservation.startTime <=:endTime)or " +
            "(reservation.endTime >= :startTime and reservation.endTime <=:endTime)" +
            "and reservation.status=true )")
    List<Room> searchAvailableRoom(@Param("city") String city,
                                   @Param("maxPrice") BigDecimal maxPrice,
                                   @Param("minPrice") BigDecimal minPrice,
                                   @Param("startTime") Date startTime,
                                   @Param("endTime") Date endTime
    );
}
