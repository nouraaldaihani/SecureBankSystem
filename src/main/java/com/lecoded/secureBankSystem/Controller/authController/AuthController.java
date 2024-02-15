package com.lecoded.secureBankSystem.Controller.authController;

import com.lecoded.secureBankSystem.ob.auth.AuthenticationResponse;
import com.lecoded.secureBankSystem.ob.auth.CreatSignupRequest;
import com.lecoded.secureBankSystem.ob.auth.CreateLoginRequest;
import com.lecoded.secureBankSystem.ob.auth.LogoutResponse;
import com.lecoded.secureBankSystem.service.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<String> creatUser(@RequestBody CreatSignupRequest creatSignupRequest) {
        try {
            authService.signup(creatSignupRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("user created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error while creating");
        }

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody CreateLoginRequest createLoginRequest){
        AuthenticationResponse response=authService.login(createLoginRequest);
        HttpStatus status= HttpStatus.OK;
        if (response==null){
            status=HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }
    @PostMapping("/logout")
    public ResponseEntity<Void>logout(@RequestBody LogoutResponse logoutResponse){
        authService.logout(logoutResponse);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}