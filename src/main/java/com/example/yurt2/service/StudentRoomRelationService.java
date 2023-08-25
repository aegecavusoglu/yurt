package com.example.yurt2.service;

import com.example.yurt2.entity.*;
import com.example.yurt2.request.StudentContractCreateRequest;
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
    StudentContractService studentContractService;

    public StudentRoomRelationService(StudentRoomRelationEntityService studentRoomRelationEntityService, RoomFeatureService roomFeatureService, StudentService studentService,RoomService roomService,StudentContractService studentContractService) {
        this.studentRoomRelationEntityService = studentRoomRelationEntityService;
        this.roomFeatureService = roomFeatureService;
        this.studentService = studentService;
        this.roomService=roomService;
        this.studentContractService= studentContractService;
    }

    public StudentRoomRelation getOneStudentRoomRelationById(Long studentRoomRelationId) {
        return studentRoomRelationEntityService.getOneStudentRoomRelationById(studentRoomRelationId);
    }


    public StudentRoomRelation createOneStudentRoomRelation(StudentRoomRelation newStudentRoomRelation) {
        Optional<Long> studentRoomRelationId =studentRoomRelationEntityService.findActiveStudentRoomRelationIdByStudentId(newStudentRoomRelation.getStudentId());
        Date today =new Date();
        RoomFeature roomFeature = roomFeatureService.getOneRoomFeatureByRoomId(newStudentRoomRelation.getRoomId());
        if(!roomFeature.isFull()){
            if (studentRoomRelationId.isPresent()) {
                StudentRoomRelation studentRoomRelation = getOneStudentRoomRelationById(studentRoomRelationId.get());
                studentRoomRelation.setEndDate(today);
                roomFeatureService.decreaseInstanceRoomCapacity(studentRoomRelation.getRoomId());
            }
            if (studentContractService.getOneContractByStudentId(newStudentRoomRelation.getStudentId())==null){
                StudentContractCreateRequest studentContractCreateRequest=new StudentContractCreateRequest();
                studentContractCreateRequest.setStudentId(newStudentRoomRelation.getStudentId());
                studentContractService.createOneContract(studentContractCreateRequest);
            }
            roomFeatureService.increaseInstanceRoomCapacity(newStudentRoomRelation.getRoomId());
            newStudentRoomRelation.setStartDate(today);
            return studentRoomRelationEntityService.createOneStudentRoomRelation(newStudentRoomRelation);
        }
        return null;

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
