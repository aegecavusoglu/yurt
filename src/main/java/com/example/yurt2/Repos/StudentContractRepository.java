package com.example.yurt2.Repos;

import com.example.yurt2.Entities.StudentContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentContractRepository extends JpaRepository<StudentContract,Long> {

    Optional<StudentContract> findByStudentId(Long studentId);
}
