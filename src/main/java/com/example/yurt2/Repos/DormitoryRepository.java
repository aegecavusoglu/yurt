package com.example.yurt2.Repos;


import com.example.yurt2.Entities.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DormitoryRepository extends JpaRepository<Dormitory,Long> {

    List<Dormitory> findByAdminId(Long adminId);
}
