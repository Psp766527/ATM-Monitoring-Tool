package com.kinective.atm.application.atm.service;

import com.kinective.atm.centralizedExceptions.ResourceNotFoundException;
import com.kinective.atm.domain.entities.atmDevice.ATMDevice;
import com.kinective.atm.infrastructure.atmDeviceRepository.ATMDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pradeep Kushwah
 * The below ATM Device Service class is basically for fetching the Atm Device related info, It contains two methods
 */
@RequiredArgsConstructor
@Service
public class ATMDeviceService {

    @Autowired
    private final ATMDeviceRepository atmDeviceRepository;

    /**
     * The getAllDevices method will return all the devices
     *
     * @return List of all devices.
     */
    public List<ATMDevice> getAllDevices() {

        List<ATMDevice> atmDeviceList = atmDeviceRepository.findAll();

        if (atmDeviceList.isEmpty()) {
            throw new ResourceNotFoundException("No ATM Device Found");
        }
        return atmDeviceList;
    }


    /**
     * This method will return a single device based on the device id.
     *
     * @param id the ID of the ATM device.
     * @return ATM Device
     */
    public ATMDevice monitorDevice(String id) {

        return atmDeviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No ATM Device not found"));
    }

    public ATMDevice registerDevice(ATMDevice atmDevice) {

        try {
            return atmDeviceRepository.save(atmDevice);
        } catch (Exception e) {
            throw new RuntimeException("Some Error while register ATM devices");
        }
    }
}
