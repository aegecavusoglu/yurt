package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Admin;
import com.example.yurt2.Repos.AdminRepository;
import com.example.yurt2.Services.AdminService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admins")
public class AdminController {
    private AdminService adminService;//Bunlar adminRepository idi, controllerdan bağlanmak için serviceRepo yaptık.
//alperen
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }
    @PostMapping
    public Admin createAdmin(@RequestBody Admin newAdmin){
        return adminService.saveAnAdmin(newAdmin);
    }
    @GetMapping("/{adminId}")
    public Admin getOneUser(@PathVariable Long adminId){
        return adminService.getOneAdmin(adminId);
    }
    @PutMapping("/{adminId}")
    public Admin updateOneAdmin(@PathVariable Long adminId,@RequestBody Admin newAdmin){
        return adminService.updateOneAdmin(adminId,newAdmin);
    }

    @DeleteMapping("/{adminId}")
    public void deleteOneAdmin(@PathVariable Long adminId){
        adminService.deleteById(adminId);
    }

}
