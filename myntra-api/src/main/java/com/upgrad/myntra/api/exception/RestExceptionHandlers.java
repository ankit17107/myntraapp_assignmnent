package com.upgrad.myntra.api.exception;

import com.upgrad.myntra.api.model.ErrorResponse;
import com.upgrad.myntra.service.exception.AuthenticationFailedException;
import com.upgrad.myntra.service.exception.SignUpRestrictedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandlers {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> signUpRestrictions(SignUpRestrictedException s, WebRequest webRequest) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(s.getCode()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> authFailedException(AuthenticationFailedException s, WebRequest webRequest) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(s.getCode()).message(s.getErrorMessage()), HttpStatus.BAD_REQUEST);

    }
}