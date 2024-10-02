package com.kinective.atm.infrastructure.failureRepository;

import com.kinective.atm.domain.entities.failure.Failure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FailureRepository extends MongoRepository<Failure,String> {

    List<Failure> findByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);

    List<Failure> findByFailureType(String failureType);

    List<Failure> findByTransactionType(String transactionType);

}
