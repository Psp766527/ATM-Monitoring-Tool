package com.kinective.atm.domain.entities.failureLog;

import com.kinective.atm.commons.Constants;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = Constants.failureLogCollection)
public class FailureLog {

    @Id
    private String id;
    private String message;
    private String severity;
    private String timestamp;

}
