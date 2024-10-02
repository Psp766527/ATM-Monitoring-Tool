package com.kinective.atm.centralizedExceptions;

public class InvalidInputException extends RuntimeException{

    public InvalidInputException(String customMessage){
        super(customMessage);
    }
}
