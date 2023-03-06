package org.testing.service.testdrivenservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.testing.service.testdrivenservice.exception.CustomerException;
import org.testing.service.testdrivenservice.exception.model.CustomerExceptionResponse;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomerExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomerExceptionResponse> PersonExceptionHandler(CustomerException ex, WebRequest request) throws Exception {
        CustomerExceptionResponse personException = new CustomerExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<CustomerExceptionResponse>(personException, HttpStatus.NOT_FOUND);
    }
}
