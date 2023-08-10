package com.example.yurt2.Requests;


public class StudentCreateRequest {
    private Long id;
    private String identityNumber;
    private String name;
    private String surname;
    private String phoneNumber;
    private String familyNumber;
    private String addressId;
    private String school;

    public StudentCreateRequest(Long id, String identityNumber, String name, String surname,
                                String phoneNumber, String familyNumber, String addressId, String school) {
        this.id = id;
        this.identityNumber = identityNumber;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.familyNumber = familyNumber;
        this.addressId = addressId;
        this.school = school;
    }
    public StudentCreateRequest(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(String familyNumber) {
        this.familyNumber = familyNumber;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
