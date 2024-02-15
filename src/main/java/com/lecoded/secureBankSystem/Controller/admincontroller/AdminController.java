package com.lecoded.secureBankSystem.Controller.admincontroller;

import com.lecoded.secureBankSystem.entity.UserEntity;
import com.lecoded.secureBankSystem.service.admin.AdminService;
import com.lecoded.secureBankSystem.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-dashboard")
public class AdminController {
    private final AdminService adminService;
    private final UserService userService;


    public AdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }
    public ResponseEntity<List<String>> getAllUsersWithStrongPasssword(){
        List<String> getAllusers= userService.getALlUsersWithStrongPassword();
        return ResponseEntity.ok(getAllusers);

    }
    @GetMapping("/get_users")
    public List<UserEntity> getAllUsers(){
        return adminService.getAllUsers();
    }
}
