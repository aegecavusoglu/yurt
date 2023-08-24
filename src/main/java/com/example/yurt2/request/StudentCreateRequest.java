package com.example.yurt2.request;

import lombok.Data;

@Data
public class StudentCreateRequest {
    private String identityNumber;
    private String name;
    private String surname;
    private String phoneNumber;
    private String familyNumber;
    private Long addressId;
    private String schoolName;
    private AddressCreateRequest addressCreateRequest;
}
