package com.example.yurt2.service;

import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.Student;
import com.example.yurt2.entity.StudentRoomRelation;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    RoomEntityService roomEntityService;
    StudentRoomRelationEntityService studentRoomRelationEntityService;
    StudentService studentService;


    public RoomService(RoomEntityService roomEntityService,StudentRoomRelationEntityService studentRoomRelationEntityService,StudentService studentService) {
        this.roomEntityService = roomEntityService;
        this.studentRoomRelationEntityService=studentRoomRelationEntityService;
        this.studentService=studentService;
    }
    public List<Room> getAllRooms() {
        return roomEntityService.getAllRooms();
    }
    public Room getOneRoomByRoomNumber(Long roomNumber) {
        return roomEntityService.getOneRoomByRoomNumber(roomNumber);

    }
    public Room createRoom(Room newRoom) {
       return roomEntityService.createOneRoom(newRoom);
    }

    public Room updateRoom(Long roomNumber, Room newRoom) {
        var room = roomEntityService.updateOneRoom(roomNumber,newRoom);
        return room;
    }

    public void deleteById(Long roomId)
    {
        roomEntityService.deleteById(roomId);
    }


    public List<StudentRoomRelation> getAllRelationsForOneRoomByRoomNumber(Long roomNumber) {
        return studentRoomRelationEntityService.getAllRelationsForOneRoomByRoomId(getOneRoomByRoomNumber(roomNumber).getId());
    }


    public List<Student> getStudentInOneRoom(Long roomNumber) {
        List<StudentRoomRelation> studentRoomRelation= getAllRelationsForOneRoomByRoomNumber(roomNumber);
        List<Student> students=new ArrayList<>();
        for (int i=0;i<studentRoomRelation.size();i++){
            students.add(studentService.getOneStudentById(studentRoomRelation.get(i).getStudentId()));
        }
        return students;
    }
}
