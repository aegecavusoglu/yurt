package com.example.yurt2.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="dormitory")
public class Dormitory {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="address_id")
    private int address_id;
    @Column(name="general_capacity")
    private int general_capacity;

    public Dormitory(Long id, String name, int address_id, int general_capacity) {
        this.id = id;
        this.name = name;
        this.address_id = address_id;
        this.general_capacity = general_capacity;
    }
    public Dormitory(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getGeneral_capacity() {
        return general_capacity;
    }

    public void setGeneral_capacity(int general_capacity) {
        this.general_capacity = general_capacity;
    }
}
