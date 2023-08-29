package com.example.yurt2.service;

import com.example.yurt2.entity.Address;
import com.example.yurt2.entity.RoomFeature;
import com.example.yurt2.exception.AddressNotFoundException;
import com.example.yurt2.exception.NoFreeRoomException;
import com.example.yurt2.exception.RoomFeatureNotFoundException;
import com.example.yurt2.repository.RoomFeatureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomFeatureEntityService {
    RoomFeatureRepository roomFeatureRepository;
    public RoomFeatureEntityService(RoomFeatureRepository roomFeatureRepository)
    {
        this.roomFeatureRepository=roomFeatureRepository;}

    public List<RoomFeature> getAllRoomFeature(){
        //return roomFeatureRepository.findAll();
        List<RoomFeature> roomFeatures = roomFeatureRepository.findAll();
        if(roomFeatures.isEmpty()){
            throw new RoomFeatureNotFoundException("RoomFeatures could not found.");

        }
        else{
            return roomFeatures;
        }
    }
    public RoomFeature createOneRoomFeature(RoomFeature newRoomFeature) {
        return roomFeatureRepository.save(newRoomFeature);
    }
    public RoomFeature getOneRoomFeatureByRoomId(Long roomId) {
        return roomFeatureRepository.findByRoomId(roomId).orElseThrow(()->new RoomFeatureNotFoundException("RoomFeature of the room with id:" + roomId + " is not found."));

    }
    public RoomFeature updateOneRoomFeature(Long roomId, RoomFeature newRoomFeature) {
        Optional<RoomFeature> roomFeature=roomFeatureRepository.findByRoomId((roomId));
        if(roomFeature.isPresent()){
            RoomFeature foundRoomFeature=roomFeature.get();
            foundRoomFeature.setRoomType(newRoomFeature.getRoomType());
            foundRoomFeature.setPrice(newRoomFeature.getPrice());
            roomFeatureRepository.save(foundRoomFeature);
            return foundRoomFeature;
        }
        else{
            throw new RoomFeatureNotFoundException("RoomFeature of the room with id:" + roomId + " is not found.");
        }
    }
    public void updateInstanceRoomCapacity(Long roomId, int instanceRoomCapacity){
        Optional<RoomFeature> roomFeature=roomFeatureRepository.findByRoomId((roomId));
        if(roomFeature.isPresent()){
            RoomFeature foundRoomFeature=roomFeature.get();
            foundRoomFeature.setInstantRoomCapacity(instanceRoomCapacity);
            roomFeatureRepository.save(foundRoomFeature);
        }
    }
    public Long findDormitoryId(Long roomId){
        return roomFeatureRepository.findDormitoryId(roomId);
    }
    public void deleteRoomFeatureById(Long roomId){
        roomFeatureRepository.deleteByRoomId(roomId);
    }


    public List<RoomFeature> findTheMostCrowdedRoom() {
        List<Long> roomId=roomFeatureRepository.findTheMostCrowdedRoom();
        List<RoomFeature> roomFeatures = new ArrayList<>();
        for(int i=0;i<roomId.size();i++){
            roomFeatures.add(getOneRoomFeatureByRoomId(roomId.get(i)));
        }
        return roomFeatures;
    }


    public List<RoomFeature> findRoomFeatureByRoomId(Long roomId) {
        return roomFeatureRepository.findRoomFeatureByRoomId(roomId);
    }

    public List<RoomFeature> getFreeRooms() {
        //return roomFeatureRepository.findByIsFullIsFalse();
        List<RoomFeature> freeRooms = roomFeatureRepository.findByIsFullIsFalse();
        if(freeRooms.isEmpty()){
            throw new NoFreeRoomException("All rooms have at least 1 enrolled student.");

        }
        else{
            return freeRooms;
        }


    }
}
