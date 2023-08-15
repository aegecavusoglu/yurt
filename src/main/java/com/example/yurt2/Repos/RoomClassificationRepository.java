package com.example.yurt2.Repos;

import com.example.yurt2.Entities.RoomClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomClassificationRepository extends JpaRepository<RoomClassification,Long> {


    Optional<RoomClassification> findByRoomType(Long roomType);
}
