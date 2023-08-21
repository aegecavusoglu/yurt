package com.example.yurt2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="room")

public class Room {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="room_number")
    private int roomNumber;
    @Column(name="dormitory_id")
    private Long dormitoryId;


    public Room(Long id, int roomNumber, Long dormitoryId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.dormitoryId = dormitoryId;
    }

    public Room(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Long dormitoryId) {
        this.dormitoryId = dormitoryId;
    }
}
