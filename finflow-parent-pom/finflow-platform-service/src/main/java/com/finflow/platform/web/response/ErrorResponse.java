package com.finflow.platform.web.response;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

	private boolean success;
	private String errorCode;
	private String message;
	private String path;
	private String correlationId;
	private Instant timestamp;

}