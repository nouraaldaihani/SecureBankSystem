package com.lecoded.secureBankSystem.service.auth;

import com.lecoded.secureBankSystem.ob.auth.AuthenticationResponse;
import com.lecoded.secureBankSystem.ob.auth.CreatSignupRequest;
import com.lecoded.secureBankSystem.ob.auth.CreateLoginRequest;
import com.lecoded.secureBankSystem.ob.auth.LogoutResponse;

public interface AuthService {

    void signup(CreatSignupRequest createSignupRequest);


    AuthenticationResponse login(CreateLoginRequest createLoginRequest);
    void logout(LogoutResponse logoutResponse);
}
