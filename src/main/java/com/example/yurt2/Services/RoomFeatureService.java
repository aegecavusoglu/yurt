package com.example.yurt2.Services;

import com.example.yurt2.Entities.Room;
import com.example.yurt2.Entities.RoomFeature;
import com.example.yurt2.Repos.RoomFeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomFeatureService {
    RoomFeatureRepository roomFeatureRepository;
    public RoomFeatureService(RoomFeatureRepository roomFeatureRepository)
    {
        this.roomFeatureRepository=roomFeatureRepository;}

    public List<RoomFeature> getAllRoomFeature(){
        return roomFeatureRepository.findAll();
    }
    public RoomFeature createOneRoomFeature(RoomFeature newRoomFeature) {
        return roomFeatureRepository.save(newRoomFeature);
    }
    public RoomFeature getOneRoomFeatureByRoomId(Long roomId) {
        return roomFeatureRepository.findByRoomId(roomId).orElse(null);

    }
    public RoomFeature updateOneRoomFeature(Long roomId, RoomFeature newRoomFeature) {
        Optional<RoomFeature> roomFeature=roomFeatureRepository.findByRoomId((roomId));
        if(roomFeature.isPresent()){
            RoomFeature foundRoomFeature=roomFeature.get();
            foundRoomFeature.setRoomId(newRoomFeature.getRoomId());
            foundRoomFeature.setInstantRoomCapacity(newRoomFeature.getInstantRoomCapacity());
            foundRoomFeature.setRoomType(newRoomFeature.getRoomType());
            foundRoomFeature.setFull(newRoomFeature.isFull());
            roomFeatureRepository.save(foundRoomFeature);
            return foundRoomFeature;
        }
        else{
            return null;
        }
    }
    public void deleteRoomFeatureById(Long roomId){
        roomFeatureRepository.deleteByRoomId(roomId);
    }

}
