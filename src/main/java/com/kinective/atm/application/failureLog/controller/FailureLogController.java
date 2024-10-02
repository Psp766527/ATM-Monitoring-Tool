package com.kinective.atm.application.failureLog.controller;

import com.kinective.atm.application.failureLog.service.FailureMonitoringService;
import com.kinective.atm.domain.entities.failureLog.FailureLog;
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
@RequestMapping("/api/atm/log/failure")
public class FailureLogController {

    @Autowired
    private final FailureMonitoringService failureMonitoringService;

    @Operation(summary = "it is used for registering failure logs ",
            description = "it is used for registering failure logs ")
    @ApiResponse(responseCode = "200", description = "Returns success if failure registered successfully.")
    @PostMapping("/register")
    public ResponseEntity<FailureLog> logFailure(
            @Parameter(description = "failureLog request body", required = true)
            @RequestBody FailureLog failureLog) {

        //TODO:FailureLog request body validation

        FailureLog log = failureMonitoringService.logFailure(failureLog);
        return new ResponseEntity<>(log, HttpStatus.CREATED);
    }

    @Operation(summary = "it is used get all failure logs ",
            description = "it is used get all failure logs ")
    @ApiResponse(responseCode = "200", description = "Returns success if failure logs found successfully.")
    @GetMapping("/fetch/all")
    public ResponseEntity<List<FailureLog>> getAllFailures() {
        List<FailureLog> failures = failureMonitoringService.getAllFailures();
        return new ResponseEntity<>(failures, HttpStatus.OK);
    }

}
