package com.bezkoder.springjwt.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MessageResponse extends Response {
    private String message;
    private int status;
    private Date timestamp;
    private String path;

    public MessageResponse(HttpStatus status, String message) {
        timestamp = new Date(System.currentTimeMillis());
        this.message = message;
        this.status = status.value();
    }

    public MessageResponse(String message, HttpStatus status, String path) {
        this.message = message;
        this.status = status.value();
        this.path = path;
        timestamp = new Date(System.currentTimeMillis());
    }

}
