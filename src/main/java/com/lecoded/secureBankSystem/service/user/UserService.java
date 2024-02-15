package com.lecoded.secureBankSystem.service.user;

import com.lecoded.secureBankSystem.ob.user.CreateUserRequest;
import com.lecoded.secureBankSystem.ob.user.UpdateUserRequest;

import java.util.List;

public interface UserService {

    void saveUser(CreateUserRequest createUserRequest);
    void updateUserStatus(UpdateUserRequest updateUserRequest);

    void updateUserStatus(Long userId, UpdateUserRequest updateUserStatusRequest);

    List<String> getALlUsersWithStrongPassword();

    void updateUserRequest(UpdateUserRequest updateUserRequest);
}

