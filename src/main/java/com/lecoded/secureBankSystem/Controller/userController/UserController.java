package com.lecoded.secureBankSystem.Controller.userController;

import com.lecoded.secureBankSystem.ob.user.CreateUserRequest;
import com.lecoded.secureBankSystem.ob.user.UpdateUserRequest;
import com.lecoded.secureBankSystem.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/creat-user")
    public ResponseEntity<String> creatUser(@RequestBody CreateUserRequest creatUserRequest){
        try{
            userService.saveUser(creatUserRequest);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        userService.saveUser(creatUserRequest);
        return ResponseEntity.ok("User Created successfully");
    }
    @PutMapping("/update_user_status")
    public ResponseEntity<String> updateUser(@RequestParam Long userId, @RequestBody UpdateUserRequest updateUserRequest){
        try{
            userService.updateUserRequest(updateUserRequest);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("user updated secessfully");
    }
}