package com.example.yurt2.Entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room_features")

public class RoomFeatures {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "room_id")
    private Long room_id;
    @Column(name = "room_type")
    private int room_type;
    @Column(name = "instant_room_capacity")
    private int instant_room_capacity;
    @Column(name = "is_full")
    private boolean is_full;
    @Column(name = "price")
    private int price;
}
