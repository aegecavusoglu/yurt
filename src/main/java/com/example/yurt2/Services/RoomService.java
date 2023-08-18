package com.example.yurt2.Services;

import com.example.yurt2.Entities.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class RoomService {
    RoomEntityService roomEntityService;
    RoomFeatureService roomFeatureService;
    DormitoryService dormitoryService;
    private final TransactionTemplate transactionTemplate;

    public RoomService(RoomEntityService roomEntityService, DormitoryService dormitoryService, RoomFeatureService roomFeatureService, PlatformTransactionManager transactionTemplate) {
        this.roomEntityService = roomEntityService;
        this.dormitoryService = dormitoryService;
        this.roomFeatureService = roomFeatureService;
        this.transactionTemplate = new TransactionTemplate(transactionTemplate);
    }
    public List<Room> getAllRooms() {
        return roomEntityService.getAllRooms();
    }
    public Room getOneRoomByRoomNumber(Long roomNumber) {
        return roomEntityService.getOneRoomByRoomNumber(roomNumber);

    }
    public Room createRoomAndUpdateCapacity(Room newRoom) {
        var roomStatus = transactionTemplate.execute(p-> {
               Room room = roomEntityService.createOneRoom(newRoom);
                roomFeatureService.createRoomFeature(newRoom);
                dormitoryService.updateGeneralCapacity(findDormitoryId(newRoom.getId()));
            return room;
        });
        return roomStatus;
    }
    public Long findDormitoryId(Long roomId){
        return roomEntityService.findDormitoryId(roomId);
    }

    public Room updateRoom(Long roomNumber, Room newRoom) {
        var room = roomEntityService.updateOneRoom(roomNumber,newRoom);
        dormitoryService.updateGeneralCapacity(findDormitoryId(newRoom.getId()));
        return room;
    }

    public void deleteById(Long roomId)
    {
        roomEntityService.deleteById(roomId);
        dormitoryService.updateGeneralCapacity(findDormitoryId(roomId));
    }

}
