package com.example.yurt2.Entities;
import jakarta.persistence.*;

@Entity
@Table(name = "room_features")

public class RoomFeature extends Room{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public RoomFeature(Long id, Long roomId) {
        this.id = id;
        this.roomId = roomId;
        this.roomType = getRoomType();
        this.isFull = false;
        this.price = getPrice();
    }
    public RoomFeature(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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
    public Long getId() {
        return id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public int getInstantRoomCapacity() {
        return instantRoomCapacity;
    }
}
