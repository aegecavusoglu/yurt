package com.example.yurt2.Repos;

import com.example.yurt2.Entities.StudentContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentContractRepository extends JpaRepository<StudentContract,Long> {

    Optional<StudentContract> findByStudentId(Long studentId);
    @Query("select count(sc.isValid) from StudentContract sc join Student s on sc.studentId = s.id where sc.isValid=true and s.room_id=:roomId")
    int findActiveStudentsNumberByRoomId(@Param("roomId") Long roomId);
}
