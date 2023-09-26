package com.example.yurt2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="address_student_relation")
public class AddressStudentRelation {
    @Getter
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Column(name= "current_address_id")
    private Long currentAddressId;
    @Getter
    @Column(name = "old_address_id")
    private Long oldAddressId;
    @Getter
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "is_active")
    private boolean isActive;

    public AddressStudentRelation(Long id, Long currentAddressId, Long oldAddressId, Long studentId, boolean isActive) {
        this.id = id;
        this.currentAddressId = currentAddressId;
        this.oldAddressId = oldAddressId;
        this.studentId = studentId;
        this.isActive = isActive;
    }
    public AddressStudentRelation(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurrentAddressId(Long currentAddressId) {
        this.currentAddressId = currentAddressId;
    }

    public void setOldAddressId(Long oldAddressId) {
        this.oldAddressId = oldAddressId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
}
