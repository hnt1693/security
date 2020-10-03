package com.bezkoder.springjwt.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse extends Response {
    private String message;
    private int status;
    private Date timestamp;
    private Object data;

    public SuccessResponse( HttpStatus status,String message, Object data) {
        this.message = message;
        this.status = status.value();
        this.timestamp = new Date();
        this.data = data;
    }
    public SuccessResponse( HttpStatus status,String message) {
        this.message = message;
        this.status = status.value();
        this.timestamp = new Date();
    }

}
