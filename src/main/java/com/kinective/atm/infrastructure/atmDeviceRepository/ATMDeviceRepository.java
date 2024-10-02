package com.kinective.atm.infrastructure.atmDeviceRepository;

import com.kinective.atm.domain.entities.atmDevice.ATMDevice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATMDeviceRepository extends MongoRepository<ATMDevice, String> {
}
