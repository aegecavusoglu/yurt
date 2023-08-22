package com.example.yurt2.repository;


import com.example.yurt2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByIdentityNumber(String identityNumber);

}
