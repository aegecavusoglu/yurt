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
    private String identity_number;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="phone_number")
    private String phone_number;
    @Column(name="family_number")
    private String family_number;
    @Column(name="address_id")
    private Long address_id;
    @Column(name="school_name")
    private String school_name;

    public Student(Long id, String identity_number, String name, String surname, String phone_number, String family_number, Long address_id, String school_name) {
        this.id = id;
        this.identity_number = identity_number;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.family_number = family_number;
        this.address_id = address_id;
        this.school_name = school_name;
    }
    public Student(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public void setIdentity_number(String identity_number) {
        this.identity_number = identity_number;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFamily_number() {
        return family_number;
    }

    public void setFamily_number(String family_number) {
        this.family_number = family_number;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

}