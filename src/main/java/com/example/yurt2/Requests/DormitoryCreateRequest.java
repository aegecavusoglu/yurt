package com.example.yurt2.Requests;

import lombok.Data;

@Data

public class DormitoryCreateRequest {
    Long id;
    String name;
    Long adminId;
    int address_id;
    boolean is_valid;

}
