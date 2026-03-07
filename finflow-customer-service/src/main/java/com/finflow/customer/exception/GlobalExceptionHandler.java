package com.finflow.customer.exception;

import java.time.Instant;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.finflow.platform.exception.PlatformException;
import com.finflow.platform.web.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PlatformException.class)
	public ResponseEntity<ErrorResponse> handlePlatformException(PlatformException ex, HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse(false, ex.getErrorCode(), ex.getMessage(), request.getRequestURI(),
				UUID.randomUUID().toString(), Instant.now());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex, HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse(false, "FINFLOW-500", "Internal server error", request.getRequestURI(),
				UUID.randomUUID().toString(), Instant.now());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
