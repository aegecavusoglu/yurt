package com.example.yurt2.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class StudentContractCreateRequest {
    private Long studentId;
    private Date contractStartDate;
    private LocalDate contractEndDate;
}
