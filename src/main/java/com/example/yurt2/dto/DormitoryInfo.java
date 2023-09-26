package com.example.yurt2.dto;

import com.example.yurt2.entity.Dormitory;

public class DormitoryInfo {

    private Dormitory dormitory;

    private String city;

    private String country;

    private String street;

    private String addressDescription;
    private String addressType;


    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public String getAddressType() {
        return addressType;
    }
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }
}
