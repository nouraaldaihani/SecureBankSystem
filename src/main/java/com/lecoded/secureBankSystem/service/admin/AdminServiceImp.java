package com.lecoded.secureBankSystem.service.admin;


import com.lecoded.secureBankSystem.entity.UserEntity;
import com.lecoded.secureBankSystem.repository.Userrepository;

import java.util.List;

public class AdminServiceImp implements AdminService {
        private final Userrepository userRepository;
        public AdminServiceImp(Userrepository userRepository){
            this.userRepository = userRepository;
        }
        @Override
        public List<UserEntity> getAllUsers(){
            return userRepository.findAll();
        }
    }