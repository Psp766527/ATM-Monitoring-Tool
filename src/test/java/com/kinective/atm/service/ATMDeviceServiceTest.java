package com.kinective.atm.service;

import com.kinective.atm.domain.entities.atmDevice.ATMDevice;
import com.kinective.atm.infrastructure.atmDeviceRepository.ATMDeviceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ATMDeviceServiceTest {

    @Autowired
    private ATMDeviceRepository atmDeviceRepository;

    @Test
    void getAllDevices() {

        ATMDevice atmDevice = new ATMDevice("123", "success", "healthy");
        atmDeviceRepository.save(atmDevice);

        List<ATMDevice> atmDevices = atmDeviceRepository.findAll();
        assertThat(atmDevices).isNotEmpty();
    }

    @Test
    void monitorDevice() {
    }

    @Test
    void registerDevice() {
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down");
      //  atmDeviceRepository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        System.out.println("setting up");
    }

}