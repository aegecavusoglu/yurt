package com.example.yurt2.repository;


import com.example.yurt2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;



public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByIdentityNumber(String identityNumber);

    List<Student> getStudentByName(String name);


    @Query(" SELECT schoolName, COUNT(*) AS studentCount FROM Student GROUP BY schoolName ORDER BY studentCount DESC")
    List<String> getSchoolListWithStudentCount();

    List<Student> findStudentByNameAndSurname(String name,String surname);

}
