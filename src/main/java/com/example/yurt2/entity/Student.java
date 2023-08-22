package com.example.yurt2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="identity_number")
    private String identityNumber;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="family_number")
    private String familyNumber;
    @Column(name="address_id")
    private Long addressId;
    @Column(name="school_name")
    private String schoolName;

    public Student(Long id, String identityNumber, String name, String surname, String phoneNumber, String familyNumber, Long addressId, String schoolName) {
        this.id = id;
        this.identityNumber = identityNumber;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.familyNumber = familyNumber;
        this.addressId = addressId;
        this.schoolName = schoolName;
    }

    public Student(){}

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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
