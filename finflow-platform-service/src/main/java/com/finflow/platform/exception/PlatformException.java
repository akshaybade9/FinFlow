package com.finflow.platform.exception;

public class PlatformException extends RuntimeException {

    private final String errorCode;

    public PlatformException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public PlatformException(String message) {
        super(message);
        this.errorCode = "FINFLOW-500";
    }

    public String getErrorCode() {
        return errorCode;
    }
}