package com.example.yurt2.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Admin")
@Data
public class Admin {


    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name="Password")
    private String password;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
