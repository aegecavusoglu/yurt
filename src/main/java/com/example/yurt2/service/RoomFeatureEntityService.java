package com.example.yurt2.service;

import com.example.yurt2.entity.RoomFeature;
import com.example.yurt2.repository.RoomFeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomFeatureEntityService {
    RoomFeatureRepository roomFeatureRepository;
    public RoomFeatureEntityService(RoomFeatureRepository roomFeatureRepository)
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
            foundRoomFeature.setPrice(newRoomFeature.getPrice());
            roomFeatureRepository.save(foundRoomFeature);
            return foundRoomFeature;
        }
        else{
            return null;
        }
    }
    public Long findDormitoryId(Long roomId){
        return roomFeatureRepository.findDormitoryId(roomId);
    }
    public void deleteRoomFeatureById(Long roomId){
        roomFeatureRepository.deleteByRoomId(roomId);
    }

}
