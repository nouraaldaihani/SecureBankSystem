package com.lecoded.secureBankSystem.util.excption;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String str){
        super(str);
    }
}