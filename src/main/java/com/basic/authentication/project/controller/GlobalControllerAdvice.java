package com.basic.authentication.project.controller;

import com.basic.authentication.project.models.Error;
import com.basic.authentication.project.utils.exceptions.ResponseAuthorizationException;
import com.basic.authentication.project.utils.exceptions.ResponseBadRequestException;
import com.basic.authentication.project.utils.exceptions.ResponseForbiddenException;
import com.basic.authentication.project.utils.exceptions.ResponseInternalServerErrorException;
import com.basic.authentication.project.utils.exceptions.ResponseNotFoundException;
import com.basic.authentication.project.utils.exceptions.ResponseServiceUnavailableException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ResponseBadRequestException.class)
    public ResponseEntity<Error> handlerBadRequestException(ResponseBadRequestException ex){
        log.error("BadRequestException {}", ex.getMessage());
        var error = Error.builder()
                .status(HttpStatus.BAD_REQUEST)
                .date(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ResponseAuthorizationException.class)
    public ResponseEntity<Error> handlerAuthorizationException(ResponseAuthorizationException ex){
        log.error("AuthorizationException {}", ex.getMessage());
        var error = Error.builder()
                .status(HttpStatus.UNAUTHORIZED)
                .date(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }


    @ExceptionHandler(ResponseForbiddenException.class)
    public ResponseEntity<Error> handlerForbiddenException(ResponseForbiddenException ex){
        log.error("ForbiddenException {}", ex.getMessage());
        var error = Error.builder()
                .status(HttpStatus.FORBIDDEN)
                .date(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    public ResponseEntity<Error> handlerNotFoundException(ResponseNotFoundException ex){
        log.error("NotFoundException {}", ex.getMessage());
        var error = Error.builder()
                .status(HttpStatus.NOT_FOUND)
                .date(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(ResponseInternalServerErrorException.class)
    public ResponseEntity<Error> handlerInternalServerErrorException(ResponseInternalServerErrorException ex){
        log.error("InternalServerErrorException {}", ex.getMessage());
        var error = Error.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .date(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    @ExceptionHandler(ResponseServiceUnavailableException.class)
    public ResponseEntity<Error> handlerBadRequestException(ResponseServiceUnavailableException ex){
        log.error("ServiceUnavailableException {}", ex.getMessage());
        var error = Error.builder()
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .date(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
    }

}
