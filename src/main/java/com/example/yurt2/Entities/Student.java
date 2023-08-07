package com.example.yurt2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Student")
public class Student {
    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)//?Arastir.
    @JoinColumn(name = "RoomId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//Bir room silinince onunla ilgili tarih de silinsin.Opsiyonel olmalı bence.
    @JsonIgnore
    Room room;
    @Column(name="IdentityNumber")
    private String identity_number;//Kontrol et
    @Column(name="Name")
    private String name;
    @Column(name="Surname")
    private String surname;
    @Column(name="PhoneNumber")
    private String phone_number;
    @Column(name="FamilyNumber")
    private String family_number;
    @Column(name="Address")
    private String adress;
    @Column(name="School")
    private String school;
    //@Column(name="StudentStoryId")
    //private int student_history_id;
    @Column(name="ContractStartDate")
    private Date contract_start_date;
    @Column(name="ContractEndDate")
    private Date contract_end_date;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
