package com.example.yurt2.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="room_classification")
public class RoomClassification {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="room_type")
    private int roomType;
    @Column(name="dormitory_id")
    private int dormitoryId;
    @Column(name = "price")
    private int price;

    public RoomClassification(Long id, int roomType, int dormitoryId, int price) {
        this.id = id;
        this.roomType = roomType;
        this.dormitoryId = dormitoryId;
        this.price = price;
    }
    public RoomClassification(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public long getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(int dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
