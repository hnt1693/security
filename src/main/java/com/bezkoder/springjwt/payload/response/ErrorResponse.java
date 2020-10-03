package com.bezkoder.springjwt.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse extends Response {
    private Date timestamp;
    private String message;
    private int status;

    public ErrorResponse( HttpStatus status,String message) {
        this.timestamp = new Date();
        this.message = message;
        this.status = status.value();
    }
}
