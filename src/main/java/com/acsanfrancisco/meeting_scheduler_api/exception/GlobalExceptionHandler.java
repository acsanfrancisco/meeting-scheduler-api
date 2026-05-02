package com.acsanfrancisco.meeting_scheduler_api.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SchedulingNotFoundException.class)
    public ResponseEntity<ErrorMessage> schedulingNotFoundException(SchedulingNotFoundException exception, HttpServletRequest request){
        log.error("SchedulingNotFound Api Error - {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> genericError(Exception exception, HttpServletRequest request){
        log.error("Unexpected Api Error - {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request){
        log.error("MethodArgumentNotValid Api Error - {}", exception.getMessage());
        BindingResult result = exception.getBindingResult();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, "One or more fields are invalid", result));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> httpMessageNotReadableException(HttpMessageNotReadableException exception, HttpServletRequest request){
        log.error("MessageNotReadable Api Error - {}", exception.getMessage());
       return ResponseEntity.status(HttpStatus.BAD_REQUEST)
               .contentType(MediaType.APPLICATION_JSON)
               .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, "Invalid Json"));
    }

    @ExceptionHandler(SchedulingAlreadyCanceledException.class)
    public ResponseEntity<ErrorMessage> schedulingAlreadyCanceledException(SchedulingAlreadyCanceledException exception, HttpServletRequest request){
        log.error("SchedulingAlreadyCanceled Api Error - {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, exception.getMessage()));
    }
}