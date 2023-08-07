package com.example.yurt2.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Dormitory")
public class Dormitory {
    @Id
    @Column(name="Id")
    private Long id;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="adminId",nullable = false)

    Admin admin;

    @Column(name="Name")
    private String name;

    /*@Column(name="ContractStartDate")
    private Date contract_start_date;
    @Column(name="ContractEndDate")
    private Date contract_end_date;
    */
    @Column(name="IsValid")
    private boolean is_valid;
    @Column(name="AddressId")
    private int address_id;

    //@Column(name="RoomId")
    //private int room_id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
