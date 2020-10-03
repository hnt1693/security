package com.bezkoder.springjwt.exceptions;

public class AuthException extends Exception {
    public AuthException(String s){
        super("Lỗi :" + s);
    }
}
