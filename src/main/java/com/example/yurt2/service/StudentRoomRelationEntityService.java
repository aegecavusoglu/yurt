package com.example.yurt2.service;

import com.example.yurt2.entity.StudentRoomRelation;
import com.example.yurt2.repository.StudentRoomRelationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentRoomRelationEntityService {
    StudentRoomRelationRepository studentRoomRelationRepository;

    public StudentRoomRelationEntityService(StudentRoomRelationRepository studentRoomRelationRepository) {
        this.studentRoomRelationRepository = studentRoomRelationRepository;
    }

    public StudentRoomRelation getOneStudentRoomRelationById(Long studentRoomRelationId) {
        return studentRoomRelationRepository.findById(studentRoomRelationId).orElse(null);
    }


    public StudentRoomRelation createOneStudentRoomRelation(StudentRoomRelation newStudentRoomRelation) {
        return studentRoomRelationRepository.save(newStudentRoomRelation);
    }

    public Optional<Long> findActiveStudentRoomRelationByStudentId(Long studentId){
        return studentRoomRelationRepository.findActiveStudentRoomRelationIdByStudentId(studentId);
    }

    public List<StudentRoomRelation> getAllStudentRoomRelationByStudentId(Long studentId) {
        return studentRoomRelationRepository.findAllByStudentId(studentId);
    }

    public List<StudentRoomRelation> getAllStudentRoomRelation() {
        return studentRoomRelationRepository.findAll();
    }
}
