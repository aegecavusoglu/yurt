package com.example.yurt2.Repos;


import com.example.yurt2.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Optional<Room> findByRoomNumber(Long roomNumber);
    @Query("select rc.dormitoryId from RoomClassification rc join Room r on rc.id= r.roomClassificationId where r.id=:roomId")
    Long findDormitoryId(@Param("roomId") Long roomId);
}
