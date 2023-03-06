package org.testing.service.testdrivenservice.exception.model;

import java.time.LocalDateTime;

public class CustomerExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String discription;


    public CustomerExceptionResponse(LocalDateTime timestamp, String message, String discription) {
        this.timestamp = timestamp;
        this.message = message;
        this.discription = discription;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
