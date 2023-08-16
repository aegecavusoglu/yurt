package com.example.yurt2.Repos;

import com.example.yurt2.Entities.RoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomFeatureRepository extends JpaRepository<RoomFeature,Long> {
    Optional<RoomFeature> findByRoomId(Long roomId);

    void deleteByRoomId(Long roomId);
}
