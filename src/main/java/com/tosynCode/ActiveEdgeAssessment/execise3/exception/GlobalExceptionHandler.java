package com.tosynCode.ActiveEdgeAssessment.execise3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(StockNotFoundException.class)
        public ResponseEntity<String> handleFlightNotFoundException(StockNotFoundException ex) {
            return ResponseEntity.status( HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

}
