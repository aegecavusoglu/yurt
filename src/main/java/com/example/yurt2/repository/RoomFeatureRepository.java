package com.example.yurt2.repository;

import com.example.yurt2.entity.RoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomFeatureRepository extends JpaRepository<RoomFeature,Long> {
    Optional<RoomFeature> findByRoomId(Long roomId);

    void deleteByRoomId(Long roomId);
    @Query("select r.dormitoryId from Room r where r.id=:roomId")
    Long findDormitoryId(@Param("roomId") Long roomId);



    @Query("SELECT roomId FROM RoomFeature WHERE instantRoomCapacity = (SELECT MAX(instantRoomCapacity) FROM RoomFeature)")
    List<Long> findTheMostCrowdedRoom();
    List<RoomFeature> findRoomFeatureByRoomId(Long roomId);
    List<RoomFeature> findByIsFullIsFalse();
}
