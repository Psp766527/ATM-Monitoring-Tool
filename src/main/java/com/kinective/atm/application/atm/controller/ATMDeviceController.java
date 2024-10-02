package com.kinective.atm.application.atm.controller;

import com.kinective.atm.application.atm.service.ATMDeviceService;
import com.kinective.atm.centralizedExceptions.InvalidInputException;
import com.kinective.atm.domain.entities.atmDevice.ATMDevice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/atm//device")
public class ATMDeviceController {

    @Autowired
    private final ATMDeviceService atmDeviceService;

    @Operation(summary = "it is for fetching all the ATM Devices",
            description = "if ATM devices found in then returns it ")
    @ApiResponse(responseCode = "200", description = "Returns the list of ATM devices")
    @GetMapping("/fetch/all")
    public ResponseEntity<List<ATMDevice>> getAllDevices() {
        List<ATMDevice> devices = atmDeviceService.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @Operation(summary = "it is for fetching the ATM Devices",
            description = "if ATM device found in then returns it ")
    @ApiResponse(responseCode = "200", description = "Returns the ATM device for which ID found")
    @GetMapping("/fetch/{id}")
    public ResponseEntity<ATMDevice> getATMDeviceByID(
            @Parameter(description = "device id", required = true)
            @PathVariable String id) {

        if (id == null || id.isEmpty()) {
            throw new InvalidInputException("Device Id can not be null or empty.");
        }

        ATMDevice device = atmDeviceService.monitorDevice(id);

        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @Operation(summary = "Is is used for register the ATM device",
            description = "It creates the ATM device in DB ")
    @ApiResponse(responseCode = "201", description = "returns success if Device registered.")
    @PostMapping("/register")
    public ResponseEntity<ATMDevice> registerDevice(
            @Parameter(description = "atm Device request body", required = true)
            @RequestBody ATMDevice atmDevice) {

        ATMDevice newATMDevice = atmDeviceService.registerDevice(atmDevice);

        return new ResponseEntity<>(newATMDevice, HttpStatus.CREATED);
    }
}
