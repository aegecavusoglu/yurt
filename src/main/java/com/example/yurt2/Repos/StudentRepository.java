package com.example.yurt2.Repos;


import com.example.yurt2.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {



}
