package com.example.yurt2.Entities;

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
    private Long student_id;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "start_date")
    private Date start_date;

    public StudentRoomRelation(Long id, Long student_id, Date end_date, Date start_date) {
        this.id = id;
        this.student_id = student_id;
        this.end_date = end_date;
        this.start_date = start_date;
    }

    public StudentRoomRelation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
}
