package com.lecoded.secureBankSystem.service.auth;

import com.lecoded.secureBankSystem.entity.UserEntity;
import com.lecoded.secureBankSystem.ob.customerUserDetails.CustomerUserDetails;
import com.lecoded.secureBankSystem.repository.Userrepository;
import com.lecoded.secureBankSystem.util.excption.UserNotFoundException;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService extends CustomerUserDetails {
    private final Userrepository userRepository;


    public CustomUserDetailsService(Userrepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomerUserDetails loadUserByUsername(String s) throws UserNotFoundException {
        try {
            return buildCustomUserDetailsOfUsername(s);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private CustomerUserDetails buildCustomUserDetailsOfUsername(String username) throws NotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow();
        if(user == null ){
            throw new NotFoundException("User not found");
        }
        CustomerUserDetails userDetails = new CustomerUserDetails() {
            @Override
            public CustomerUserDetails loadUserByUsername(String s) throws UserNotFoundException {
                return null;
            }
        };
        userDetails.setId(user.getId());
        userDetails.setUserName(user.getUsername());
        userDetails.setPassword(user.getPassword());
        userDetails.setRole(user.getRole().getTitle().name());

        return userDetails;
    }
}