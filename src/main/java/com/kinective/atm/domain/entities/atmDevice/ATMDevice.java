package com.kinective.atm.domain.entities.atmDevice;

import com.kinective.atm.commons.Constants;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = Constants.atmDeviceCollection)
public class ATMDevice {

    @Id
    @Field("atmDeviceID")
    private String id;

    @Field("deviceStatus")
    private String status;

    @Field("deviceHealth")
    private String health;

}
