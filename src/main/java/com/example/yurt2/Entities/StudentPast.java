package com.example.yurt2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="studentsPast")

public class StudentPast {

    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)//?Arastir.
    @JoinColumn(name = "studentId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//Bir student silinince onunla ilgili tarih de silinsin.Opsiyonel olmalı bence.
    @JsonIgnore
    Student student;


    @Column(name="start_date")
    private Date start_date;
    @Column(name="end_date")
    private Date end_date;

    @Column(name="room_number")
    private int room_number;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}