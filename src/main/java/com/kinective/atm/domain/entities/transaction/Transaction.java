package com.kinective.atm.domain.entities.transaction;

import com.kinective.atm.commons.Constants;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = Constants.transactionCollection)
public class Transaction {

    @Id
    private String id;
    private String type;
    private double amount;
    private LocalDateTime timeStamp;

}
