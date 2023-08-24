package com.example.yurt2.request;

import lombok.Data;

@Data
public class AddressCreateRequest {
    private String street;
    private String city;
    private String country;
    private String addressType;
    private String addressDescription;
}
