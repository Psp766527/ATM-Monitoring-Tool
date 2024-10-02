package com.kinective.atm.centralizedExceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String customMessage) {
        super(customMessage);
    }

}
