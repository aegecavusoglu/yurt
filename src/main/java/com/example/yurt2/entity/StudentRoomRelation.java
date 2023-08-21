package com.example.yurt2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student_room_relation")
public class StudentRoomRelation {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="student_id")
    private Long studentId;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "room_id")
    private Long roomId;

    public StudentRoomRelation(Long id, Long studentId, Date endDate, Date startDate, Long roomId) {
        this.id = id;
        this.studentId = studentId;
        this.endDate = endDate;
        this.startDate = startDate;
        this.roomId = roomId;
    }

    public StudentRoomRelation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
