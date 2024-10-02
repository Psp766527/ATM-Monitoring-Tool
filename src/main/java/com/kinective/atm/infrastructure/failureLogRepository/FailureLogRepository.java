package com.kinective.atm.infrastructure.failureLogRepository;

import com.kinective.atm.domain.entities.failureLog.FailureLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailureLogRepository extends MongoRepository<FailureLog, String> {
}
