package com.finflow.platform.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.finflow.platform.web.response.ErrorResponse;

import java.time.Instant;
import java.util.UUID;

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