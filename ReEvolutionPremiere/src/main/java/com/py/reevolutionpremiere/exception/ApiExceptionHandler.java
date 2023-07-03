package com.py.reevolutionpremiere.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> handleException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errorMap.put(fieldName, message);
        });
        ApiException apiException = new ApiException(
                request.getRequestURI(),
               errorMap,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()

        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiException> hanldeException(NoSuchElementException ex, HttpServletRequest request) {
        Map<String,String> mapError = new HashMap<>();
        mapError.put("messagge", ex.getMessage());
        ApiException apiException = new ApiException(
                request.getRequestURI(),
                mapError,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()

        );
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiException> hanldeException(ResourceNotFoundException ex, HttpServletRequest request) {
        Map<String,String> mapError = new HashMap<>();
        mapError.put("messagge", ex.getMessage());
        ApiException apiException = new ApiException(
                request.getRequestURI(),
                mapError,
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class,RuntimeException.class})
    public ResponseEntity<ApiException> hanldeException(Exception ex, HttpServletRequest request) {
        Map<String,String> mapError = new HashMap<>();
        mapError.put("messagge", ex.getMessage());
        ApiException apiException = new ApiException(
                request.getRequestURI(),
                mapError,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

