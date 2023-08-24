package com.example.yurt2.repository;

import com.example.yurt2.entity.AddressStudentRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressStudentRelationRepository extends JpaRepository<AddressStudentRelation,Long> {
    AddressStudentRelation findByCurrentAddressId(Long currentAddressId);

    List<AddressStudentRelation> findByStudentId(Long studentId);
}
