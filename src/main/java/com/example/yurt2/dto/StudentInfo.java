package com.example.yurt2.dto;

import com.example.yurt2.entity.Student;

public class StudentInfo {

    private Student student;

    private String city;

    private String country;

    private String street;
    private String addressDescription;
    private String addressType;

    private boolean isValid;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}
