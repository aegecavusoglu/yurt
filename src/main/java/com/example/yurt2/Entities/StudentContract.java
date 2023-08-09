package com.example.yurt2.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student_contract")
public class StudentContract {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="student_id")
    private Long student_id;
    @Column(name="contract_start_date")
    private Date contract_start_date;
    @Column(name="contract_end_date")
    private Date contract_end_date;
    @Column(name = "is_valid")
    private boolean is_valid;

    public StudentContract(Long id, Long student_id, Date contract_start_date, Date contract_end_date, boolean is_valid) {
        this.id = id;
        this.student_id = student_id;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
        this.is_valid = is_valid;
    }
    public StudentContract(){}

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

    public Date getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(Date contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public Date getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(Date contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public boolean isIs_valid() {
        return is_valid;
    }

    public void setIs_valid(boolean is_valid) {
        this.is_valid = is_valid;
    }
}
