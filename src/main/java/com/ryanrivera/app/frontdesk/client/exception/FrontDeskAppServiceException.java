package com.ryanrivera.app.frontdesk.client.exception;

import lombok.Getter;

@Getter
public class FrontDeskAppServiceException extends RuntimeException {

    private ErrorResponse errorResponse;

    public FrontDeskAppServiceException(ErrorResponse errorResponse) {
        super(errorResponse.getError());
        this.errorResponse = errorResponse;
    }
}
