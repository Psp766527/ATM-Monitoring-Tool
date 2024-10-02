package com.kinective.atm.application.deviceFailure.controller;

import com.kinective.atm.application.deviceFailure.service.FailureService;
import com.kinective.atm.domain.entities.failure.Failure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/atm/failures")
@RequiredArgsConstructor
public class FailureController {

    @Autowired
    private FailureService failureService;

    @Operation(summary = "it is used for registering failure ",
            description = "it is used for registering failure ")
    @ApiResponse(responseCode = "200", description = "Returns success if failure registered successfully.")
    @PostMapping("/register")
    public ResponseEntity<Failure> registerFailure(
            @Parameter(description = "failureReqBody", required = true)
            @RequestBody Failure failureReqBody) {

        //TODO: Failure request body validation pending

        Failure failure = failureService.registerFailure(failureReqBody);
        return ResponseEntity.ok(failure);
    }


    @Operation(summary = "it is used to return failure based on the time range ",
            description = "it is used to return failure based on the time range")
    @ApiResponse(responseCode = "200", description = "returns list of failure by time range if found")
    @GetMapping("/byTimeRange")
    public ResponseEntity<List<Failure>> getFailuresByTimeRange(
            @Parameter(description = "startTime and endTime", required = true)
            @RequestParam("startTime") String startTimeStr,
            @RequestParam("endTime") String endTimeStr) {

        LocalDateTime startTime = LocalDateTime.parse(startTimeStr);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr);

        List<Failure> failures = failureService.getFailuresByTimeRange(startTime, endTime);
        return ResponseEntity.ok(failures);
    }

    @Operation(summary = "it is used to return failure based on the type of failure passed ",
            description = "it is used to return failure based on the type of failure passed")
    @ApiResponse(responseCode = "200", description = "returns list of failure by type if found")
    @GetMapping("/byType")
    public ResponseEntity<List<Failure>> getFailuresByType(
            @Parameter(description = "failureType", required = true)
            @RequestParam("failureType") String failureType) {

        List<Failure> failures = failureService.getFailuresByType(failureType);
        return ResponseEntity.ok(failures);
    }


    @Operation(summary = "it is used to return failure based on the transactionType of failure passed ",
            description = "it is used to return failure based on the transactionType of failure passed ")
    @ApiResponse(responseCode = "200", description = "returns list of failure by transactionType if found")
    @GetMapping("/byTransactionType")
    public ResponseEntity<List<Failure>> getFailuresByTransactionType(
            @Parameter(description = "transactionType", required = true)
            @RequestParam("transactionType") String transactionType) {


        List<Failure> failures = failureService.getFailuresByTransactionType(transactionType);
        return ResponseEntity.ok(failures);
    }

}
