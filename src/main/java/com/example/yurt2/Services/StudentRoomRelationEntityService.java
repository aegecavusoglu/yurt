package com.example.yurt2.Services;

import com.example.yurt2.Entities.StudentRoomRelation;
import com.example.yurt2.Repos.StudentRoomRelationRepository;
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
