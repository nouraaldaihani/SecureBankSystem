package com.lecoded.secureBankSystem.service.user;


import com.lecoded.secureBankSystem.entity.UserEntity;
import com.lecoded.secureBankSystem.ob.user.CreateUserRequest;
import com.lecoded.secureBankSystem.ob.user.UpdateUserRequest;
import com.lecoded.secureBankSystem.repository.Userrepository;
import com.lecoded.secureBankSystem.util.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService{
    private final Userrepository userRepository;

    public UserServiceImp(Userrepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);
    }

    @Override
    public void updateUserStatus(UpdateUserRequest updateUserRequest) {

    }

    @Override
    public void updateUserStatus(Long userId, UpdateUserRequest updateUserStatusRequest) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow();
        if(!updateUserStatusRequest.getStatus().equals("ACTIVE") && !updateUserStatusRequest.getStatus().equals("INACTIVE")){
            throw new IllegalArgumentException("Status should be written either ACTIVE or INACTIVE");

        }
        userEntity.setStatus(Status.valueOf(updateUserStatusRequest.getStatus()));
        userRepository.save(userEntity);
    }

    @Override
    public List<String> getALlUsersWithStrongPassword() {
        return userRepository.findAll().stream()
                .filter(user -> user.getPassword().length() > 8)
                .map(UserEntity::getName)
                .collect(Collectors.toList());
    }

    @Override
    public void updateUserRequest(UpdateUserRequest updateUserRequest) {

    }


}