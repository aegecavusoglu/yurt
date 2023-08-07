package com.example.yurt2.Services;

import com.example.yurt2.Entities.Admin;
import com.example.yurt2.Repos.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class AdminService {
    AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin saveAnAdmin(Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }

    public Admin getOneAdmin(Long adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

    public Admin updateOneAdmin(Long adminId, Admin newAdmin) {
        Optional<Admin> admin=adminRepository.findById(adminId);
        if(admin.isPresent()){
            Admin foundAdmin=admin.get();
            foundAdmin.setUsername(newAdmin.getUsername());
            foundAdmin.setPassword(newAdmin.getPassword());
            adminRepository.save(foundAdmin);
            return foundAdmin;
        }
        else{
            return null;
        }
    }

    public void deleteById(Long adminId) {
        adminRepository.deleteById(adminId);
    }
}
