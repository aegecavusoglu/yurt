package com.example.yurt2.repository;

import com.example.yurt2.entity.StudentContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentContractRepository extends JpaRepository<StudentContract,Long> {

    Optional<StudentContract> findByStudentId(Long studentId);
    @Query("select count(sc.isValid) from StudentContract sc join StudentRoomRelation srl on sc.studentId = srl.studentId where sc.isValid=true and srl.endDate=null and srl.roomId=:roomId")
    int findActiveStudentsNumberByRoomId(@Param("roomId") Long roomId);
}
