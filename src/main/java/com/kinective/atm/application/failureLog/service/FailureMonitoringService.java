package com.kinective.atm.application.failureLog.service;


import com.kinective.atm.domain.entities.failureLog.FailureLog;
import com.kinective.atm.infrastructure.failureLogRepository.FailureLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FailureMonitoringService {

    @Autowired
    private FailureLogRepository failureLogRepository;

    public FailureLog logFailure(FailureLog failureLog) {
        return failureLogRepository.save(failureLog);
    }

    public List<FailureLog> getAllFailures() {
        return failureLogRepository.findAll();
    }
}
