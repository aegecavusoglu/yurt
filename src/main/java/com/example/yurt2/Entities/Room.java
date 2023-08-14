package com.example.yurt2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private int room_number;
    @Column(name="dormitory_id")
    private int dormitory_id;


    public Room(Long id, int room_number, int dormitory_id) {
        this.id = id;
        this.room_number = room_number;
        this.dormitory_id = dormitory_id;
    }
    public Room(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public int getStudent_id() {
        return dormitory_id;
    }

    public void setStudent_id(int dormitory_id) {
        this.dormitory_id = dormitory_id;
    }
}
