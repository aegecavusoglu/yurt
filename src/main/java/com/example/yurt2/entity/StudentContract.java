package com.example.yurt2.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "student_contract")
public class StudentContract {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="student_id")
    private Long studentId;
    @Column(name="contract_start_date")
    private Date contractStartDate;
    @Column(name="contract_end_date")
    private LocalDate contractEndDate;
    @Column(name = "is_valid")
    private boolean isValid;

    public StudentContract(Long id, Long studentId, Date contractStartDate, LocalDate contractEndDate, boolean isValid) {
        this.id = id;
        this.studentId = studentId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.isValid = isValid;
    }

    public StudentContract() {
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

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean getIsValid() {
        return isValid;
    }
}
