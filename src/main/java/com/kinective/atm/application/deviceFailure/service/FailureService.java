package com.kinective.atm.application.deviceFailure.service;

import com.kinective.atm.domain.entities.failure.Failure;
import com.kinective.atm.infrastructure.failureRepository.FailureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FailureService {

    @Autowired
    private FailureRepository failureRepository;

    public List<Failure> getFailuresByTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        return failureRepository.findByTimestampBetween(startTime, endTime);
    }

    public List<Failure> getFailuresByType(String failureType) {
        return failureRepository.findByFailureType(failureType);
    }

    public List<Failure> getFailuresByTransactionType(String transactionType) {
        return failureRepository.findByTransactionType(transactionType);
    }

    public Failure registerFailure(Failure failure) {
        return failureRepository.save(failure);

    }
}
