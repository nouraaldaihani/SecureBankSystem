package com.lecoded.secureBankSystem.service.auth;

import com.lecoded.secureBankSystem.config.JWTUtil;
import com.lecoded.secureBankSystem.entity.RoleEntity;
import com.lecoded.secureBankSystem.entity.UserEntity;
import com.lecoded.secureBankSystem.ob.auth.AuthenticationResponse;
import com.lecoded.secureBankSystem.ob.auth.CreatSignupRequest;
import com.lecoded.secureBankSystem.ob.auth.CreateLoginRequest;
import com.lecoded.secureBankSystem.ob.auth.LogoutResponse;
import com.lecoded.secureBankSystem.ob.customerUserDetails.CustomerUserDetails;
import com.lecoded.secureBankSystem.repository.RoleRepository;
import com.lecoded.secureBankSystem.repository.Userrepository;
import com.lecoded.secureBankSystem.util.enums.Roles;
import com.lecoded.secureBankSystem.util.enums.Status;
import com.lecoded.secureBankSystem.util.excption.BodyGuardException;
import com.lecoded.secureBankSystem.util.excption.UserNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService{
    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService customUserDetailsService;
    private final JWTUtil jwtUtil;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private  final RoleRepository roleRepository;
    private final Userrepository userRepository;



    public AuthServiceImp(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, JWTUtil jwtUtil, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository, Userrepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void signup(CreatSignupRequest createSignupRequest) {
        RoleEntity roleEntity= roleRepository.findRoleEntityByTitle(Roles.user.name())
                .orElseThrow(() -> new BodyGuardException("no Roles Found"));
        UserEntity user= new UserEntity();
        user.setName(createSignupRequest.getName());
        user.setUsername(createSignupRequest.getUsername());
        user.setPhoneNumber(createSignupRequest.getPhoneNumber());
        user.setEmail(createSignupRequest.getEmail());
        user.setRole(roleEntity);
        user.setStatus(Status.ACTIVE);
        user.setPassword(bCryptPasswordEncoder.encode(createSignupRequest.getPassword()));
        userRepository.save(user);
    }


    @Override
    public AuthenticationResponse login(CreateLoginRequest createLoginRequest) {
        requiredNonNull(createLoginRequest.getUsername(),"username");
        requiredNonNull(createLoginRequest.getPassword(),"password");

        String username= createLoginRequest.getUsername().toLowerCase();
        String password= createLoginRequest.getPassword();
        authentication(username,password);

        CustomerUserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        String accessToken = jwtUtil.generateToken(userDetails);
        AuthenticationResponse response = new AuthenticationResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setRole(userDetails.getRole());
        response.setToken("Bearer"+ accessToken);
        return response;



    }

    @Override
    public void logout(LogoutResponse logoutResponse) {
        requiredNonNull(logoutResponse.getToken(),"Token");

    }
    private void requiredNonNull(Object obj,String name){
        if(obj == null || obj.toString().isEmpty()){
            throw new BodyGuardException(name+"can not be empty");
        }
    }
    private void authentication(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BodyGuardException e) {
            throw new BodyGuardException("Incorrect password");
        } catch (AuthenticationServiceException e) {
            throw new UserNotFoundException("Incorrect username");
        }
    }}

