package com.example.yurt2.service;

import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.Student;
import com.example.yurt2.entity.StudentRoomRelation;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentRoomRelationService {
    StudentRoomRelationEntityService studentRoomRelationEntityService;
    RoomFeatureService roomFeatureService;
    StudentService studentService;
    RoomService roomService;

    public StudentRoomRelationService(StudentRoomRelationEntityService studentRoomRelationEntityService, RoomFeatureService roomFeatureService, StudentService studentService,RoomService roomService) {
        this.studentRoomRelationEntityService = studentRoomRelationEntityService;
        this.roomFeatureService = roomFeatureService;
        this.studentService = studentService;
        this.roomService=roomService;
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

    public List<StudentRoomRelation> getAllStudentRoomRelationByStudentIdentityNumber(String studentIdentityNumber) {
        return studentRoomRelationEntityService.getAllStudentRoomRelationByStudentId(findStudentIdByStudentIdentityNumber(studentIdentityNumber));
    }
    public Long findStudentIdByStudentIdentityNumber(String studentIdentityNumber){
        Student student = studentService.getOneStudentByIdentityNumber(studentIdentityNumber).get();
        return student.getId();
    }
    public List<StudentRoomRelation> getAllStudentRoomRelation(){
        return studentRoomRelationEntityService.getAllStudentRoomRelation();
    }

    public List<StudentRoomRelation> getAllRelationsForOneRoomByRoomNumber(Long roomNumber) {
        return studentRoomRelationEntityService.getAllRelationsForOneRoomByRoomId(findRoomIdByRoomNumber(roomNumber));
    }

    public Long findRoomIdByRoomNumber(Long roomNumber){
        Room room=roomService.getOneRoomByRoomNumber(roomNumber);
        return room.getId();
    }
}
