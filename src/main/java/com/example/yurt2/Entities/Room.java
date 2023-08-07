package com.example.yurt2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="room")

public class Room {
    @Id
    @Column(name="Id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)//?Arastir.
    @JoinColumn(name = "DormitoryId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//Bir dorm silinince onunla ilgili tarih de silinsin.Opsiyonel olmalı bence.
    @JsonIgnore
    Dormitory dorm;

    @Column(name="RoomNumber")
    private int room_number;
    @Column(name="RoomCapacity")
    private int room_capacity;
    @Column(name="StudentId")
    private int student_id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
