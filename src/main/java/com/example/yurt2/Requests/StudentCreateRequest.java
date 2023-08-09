package com.example.yurt2.Requests;

import lombok.Data;

@Data
public class StudentCreateRequest {
    private Long id;
    private String identityNumber;
    private String name;
    private String surname;
    private String phoneNumber;
    private String familyNumber;
    private String addressId;
    private String school;
}
