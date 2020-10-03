package com.bezkoder.springjwt.exceptions;

public class UserValidatorException extends Exception {
    public UserValidatorException(String s) {
        super("Lỗi xác thực :" + s);
    }

}
