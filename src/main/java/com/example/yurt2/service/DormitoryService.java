package com.example.yurt2.service;

import com.example.yurt2.entity.*;
import com.example.yurt2.exception.DormitoryNotFoundException;
import com.example.yurt2.repository.DormitoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DormitoryService {
    private final  DormitoryEntityService dormitoryEntityService;
    private final RoomFeatureEntityService roomFeatureEntityService;
    private final StudentService studentService;
    private final DormitoryRepository dormitoryRepository;
    private final AddressService addressService;

    public DormitoryService(DormitoryEntityService dormitoryEntityService, RoomFeatureEntityService roomFeatureEntityService, StudentService studentService, DormitoryRepository dormitoryRepository, AddressService addressService) {
        this.dormitoryEntityService = dormitoryEntityService;
        this.roomFeatureEntityService = roomFeatureEntityService;
        this.studentService = studentService;
        this.dormitoryRepository = dormitoryRepository;
        this.addressService = addressService;
    }

    public int getCapacity(Long dormitoryId) {
        return dormitoryEntityService.getOneDormitory(dormitoryId).getGeneral_capacity();
    }

    public void updateGeneralCapacity(Long dormitoryId) {
        List<RoomFeature> roomFeatures = roomFeatureEntityService.getAllRoomFeature();
        int capacity = 0;
        for (int i = 0; i < roomFeatures.size(); i++) {
            capacity = capacity + roomFeatures.get(i).getRoomType();
        }
        dormitoryEntityService.updateGeneralCapacity(capacity, dormitoryId);
    }

    public int getFreeCapacity(Long dormitoryId) {
        return dormitoryEntityService.getOneDormitory(dormitoryId).getGeneral_capacity() - getCurrentFullCapacity(dormitoryId);
    }

    public int getCurrentFullCapacity(Long dormitoryId) {
        List<RoomFeature> roomFeatures = roomFeatureEntityService.getAllRoomFeature();
        int currentCapacity = 0;
        for (int i = 0; i < roomFeatures.size(); i++) {
            currentCapacity += roomFeatures.get(i).getInstantRoomCapacity();
        }
        return currentCapacity;
    }

    public List<RoomFeature> getFreeRooms() {
        List<RoomFeature> roomFeatures = roomFeatureEntityService.getFreeRooms();
        return roomFeatures;
    }

    public List<String> getSchoolList() {
        return studentService.getSchoolListWithStudentCount();
    }

    public int calculateOneMonthIncomes() {
        List<RoomFeature> roomFeatures = roomFeatureEntityService.getAllRoomFeature();
        int incomes = 0;
        for (int i = 0; i < roomFeatures.size(); i++) {
            incomes += roomFeatures.get(i).getInstantRoomCapacity() * roomFeatures.get(i).getPrice();
        }
        return incomes;
    }

    public Object getOneDormitoryById(Long dormitoryId) {
        return dormitoryRepository.findById(dormitoryId).orElseThrow(()->new DormitoryNotFoundException("Dormitory could not found by this id."));
    }
}
