package com.example.yurt2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="room")

public class Room {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="room_number")
    private int roomNumber;
    @Column(name="room_classification_id")
    private Long roomClassificationId;


    public Room(Long id, int roomNumber, Long roomClassificationId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomClassificationId = roomClassificationId;
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

    public void setRoomClassificationId(Long roomClassificationId) {
        this.roomClassificationId = roomClassificationId;
    }

    public Long getRoomClassificationId() {
        return roomClassificationId;
    }
}
