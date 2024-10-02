package com.kinective.atm.domain.entities.failure;

import com.kinective.atm.commons.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Document(collection = Constants.failureCollection)
public class Failure {

    @Id
    private String id;
    private String failureType;
    private String transactionType;
    private String deviceId;
    private String description;
    private LocalDateTime timestamp;
}
