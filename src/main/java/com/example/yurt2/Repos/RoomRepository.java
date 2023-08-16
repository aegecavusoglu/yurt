package com.example.yurt2.Repos;


import com.example.yurt2.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Optional<Room> findByRoomNumber(Long roomNumber);
}
