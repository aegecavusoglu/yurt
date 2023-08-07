package com.example.yurt2.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dormitory_contract")
public class DormitoryContract {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="contract_start_date")
    private Date contract_start_date;
    @Column(name="contract_end_date")
    private Date contract_end_date;
    @Column(name="dormitory_id")
    private Long dormitory_id;
    @Column(name="is_valid")
    private boolean is_valid;
}
