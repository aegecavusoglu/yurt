package com.example.yurt2.service;

import com.example.yurt2.entity.StudentRoomRelation;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentRoomRelationService {
    StudentRoomRelationEntityService studentRoomRelationEntityService;
    RoomFeatureService roomFeatureService;

    public StudentRoomRelationService(StudentRoomRelationEntityService studentRoomRelationEntityService, RoomFeatureService roomFeatureService) {
        this.studentRoomRelationEntityService = studentRoomRelationEntityService;
        this.roomFeatureService = roomFeatureService;
    }

    public StudentRoomRelation getOneStudentRoomRelationById(Long studentRoomRelationId) {
        return studentRoomRelationEntityService.getOneStudentRoomRelationById(studentRoomRelationId);
    }


    public StudentRoomRelation createOneStudentRoomRelation(StudentRoomRelation newStudentRoomRelation) {
        Optional<Long> studentRoomRelationId =studentRoomRelationEntityService.findActiveStudentRoomRelationByStudentId(newStudentRoomRelation.getStudentId());
        Date today =new Date();
        if (studentRoomRelationId.isPresent()) {
            StudentRoomRelation studentRoomRelation = getOneStudentRoomRelationById(studentRoomRelationId.get());
            newStudentRoomRelation.setEndDate(today);
            roomFeatureService.decreaseInstanceRoomCapacity(studentRoomRelation.getRoomId());

        }
        roomFeatureService.increaseInstanceRoomCapacity(newStudentRoomRelation.getRoomId());
        newStudentRoomRelation.setStartDate(today);
        return studentRoomRelationEntityService.createOneStudentRoomRelation(newStudentRoomRelation);

    }

}
