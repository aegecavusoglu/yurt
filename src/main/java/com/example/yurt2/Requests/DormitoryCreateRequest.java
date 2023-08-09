package com.example.yurt2.Requests;


public class DormitoryCreateRequest {
    Long id;
    String name;
    int address_id;

    public DormitoryCreateRequest(Long id, String name, int address_id) {
        this.id = id;
        this.name = name;
        this.address_id = address_id;
    }
    public DormitoryCreateRequest(){}

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
}
