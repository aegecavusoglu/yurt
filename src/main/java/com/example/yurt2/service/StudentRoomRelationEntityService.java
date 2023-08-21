package com.example.yurt2.service;

import com.example.yurt2.entity.StudentRoomRelation;
import com.example.yurt2.repository.StudentRoomRelationRepository;
import org.springframework.stereotype.Service;

@Service

public class StudentRoomRelationEntityService {
    StudentRoomRelationRepository studentRoomRelationRepository;
    RoomEntityService roomEntityService;

    public StudentRoomRelationEntityService(StudentRoomRelationRepository studentRoomRelationRepository, RoomEntityService roomEntityService) {
        this.studentRoomRelationRepository = studentRoomRelationRepository;
        this.roomEntityService = roomEntityService;
    }

    public StudentRoomRelation getOneStudentRoomRelationById(Long studentId) {
        return studentRoomRelationRepository.findById(studentId).orElse(null);
    }


    public StudentRoomRelation createOneStudentRoomRelation(StudentRoomRelation newStudentRoomRelation) {
        return studentRoomRelationRepository.save(newStudentRoomRelation);
    }
}
