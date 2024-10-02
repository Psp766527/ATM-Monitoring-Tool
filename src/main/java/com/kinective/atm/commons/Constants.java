package com.kinective.atm.commons;

import org.springframework.beans.factory.annotation.Value;

/**
 * This class is responsible for managing common constants which is used many times in the code.
 */
public class Constants {

    /**
     * The transactionCollection documentName which is going to address the Transaction Master.
     */
    public static final String transactionCollection = "Transaction";

    /**
     * The atmDeviceCollection documentName which is going to address the ATMDevice Master.
     */
    public static final String atmDeviceCollection = "Devices";

    public static final String failureLogCollection = "FailureLog";

    public static final String failureCollection = "Failure";

    public static final String userCollection = "user";
}
