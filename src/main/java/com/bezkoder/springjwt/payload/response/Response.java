package com.bezkoder.springjwt.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Data
@NoArgsConstructor
public abstract class Response {
    private Date timestamp;
    private String message;
    private int status;
}
