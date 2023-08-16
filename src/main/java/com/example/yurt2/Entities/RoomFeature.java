package com.example.yurt2.Entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room_features")

public class RoomFeature {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "room_type")
    private int roomType;
    @Column(name = "instant_room_capacity")
    private int instantRoomCapacity;
    @Column(name = "is_full")
    private boolean isFull;
    @Column(name = "price")
    private int price;

    public RoomFeature(Long id, Long roomId, int roomType, int instantRoomCapacity, boolean isFull, int price) {
        this.id = id;
        this.roomId = roomId;
        this.roomType = roomType;
        this.instantRoomCapacity = instantRoomCapacity;
        this.isFull = isFull;
        this.price = price;
    }
    public RoomFeature(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public void setInstantRoomCapacity(int instantRoomCapacity) {
        this.instantRoomCapacity = instantRoomCapacity;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public int getRoomType() {
        return roomType;
    }

    public int getInstantRoomCapacity() {
        return instantRoomCapacity;
    }

    public int getPrice() {
        return price;
    }
}
