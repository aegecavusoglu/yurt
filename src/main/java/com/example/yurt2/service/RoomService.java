package com.example.yurt2.service;

import com.example.yurt2.dto.RoomInfo;
import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.Dormitory;
import com.example.yurt2.entity.RoomFeature;
import com.example.yurt2.entity.Student;
import com.example.yurt2.entity.StudentRoomRelation;
import com.example.yurt2.exception.RoomRelationNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class RoomService {
    private final RoomEntityService roomEntityService;
    private final StudentRoomRelationEntityService studentRoomRelationEntityService;
    private final StudentService studentService;
    private final DormitoryService dormitoryService;
    private final RoomFeatureService roomFeatureService;


    public RoomService(RoomEntityService roomEntityService, StudentRoomRelationEntityService studentRoomRelationEntityService,
                       StudentService studentService, DormitoryService dormitoryService, RoomFeatureService roomFeatureService) {
        this.roomEntityService = roomEntityService;
        this.studentRoomRelationEntityService=studentRoomRelationEntityService;
        this.studentService=studentService;
        this.dormitoryService = dormitoryService;

        this.roomFeatureService = roomFeatureService;
    }
    public List<Room> getAllRooms() {
        return roomEntityService.getAllRooms();
    }

    public List<RoomInfo> getAllRoomInfo() {

        List<RoomInfo> resp = new ArrayList<>();

        var rooms = roomEntityService.getAllRooms();

        for (Room room : rooms) {
            var dormitoryObj = dormitoryService.getOneDormitoryById(room.getDormitoryId());
            var roomFeatureObj = roomFeatureService.getOneRoomFeatureByRoomId(room.getId());
            var roomInfo = new RoomInfo();
            var dormitory = (Dormitory) dormitoryObj;
            var roomFeature = (RoomFeature) roomFeatureObj;

            roomInfo.setRoom(room);
            roomInfo.setName(dormitory.getName());
            roomInfo.setRoomType(roomFeature.getRoomType());
            roomInfo.setInstantRoomCapacity(roomFeature.getInstantRoomCapacity());
            roomInfo.setPrice(roomFeature.getPrice());
            resp.add(roomInfo);
        }

        return resp;

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
        if (studentRoomRelation.isEmpty()){
            throw new RoomRelationNotFoundException("Relation could not found for this roomNumber.");
        }
        else{
            for (int i=0;i<studentRoomRelation.size();i++){
                students.add(studentService.getOneStudentById(studentRoomRelation.get(i).getStudentId()));
            }
            return students;
        }

    }

    public List<RoomFeature> findRoomFeatureByRoomNumber(Long roomNumber) {
        var roomId = getOneRoomByRoomNumber(roomNumber).getId();
        return roomFeatureService.findRoomFeatureByRoomId(roomId);

    }

}
