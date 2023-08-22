package com.example.yurt2.repository;

import com.example.yurt2.entity.StudentRoomRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRoomRelationRepository extends JpaRepository<StudentRoomRelation,Long> {
    @Query("select srl.id from StudentRoomRelation srl where srl.endDate = null and srl.studentId=:studentId")
    Optional<Long> findActiveStudentRoomRelationIdByStudentId(@Param("studentId") Long studentId);

}
