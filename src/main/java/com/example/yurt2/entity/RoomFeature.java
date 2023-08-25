package com.example.yurt2.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "room_features")

public class RoomFeature {
    @Id
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

    public void setIsFull(boolean isFull) {
        isFull = isFull;
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
