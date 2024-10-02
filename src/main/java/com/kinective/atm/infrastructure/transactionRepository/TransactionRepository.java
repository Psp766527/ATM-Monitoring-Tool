package com.kinective.atm.infrastructure.transactionRepository;

import com.kinective.atm.domain.entities.transaction.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    @Query("{ 'timestamp': { $gte: ?0 } }")
    List<Transaction> findTransactionsInLast24Hours(LocalDateTime fromTime);

    @Query("{ 'timestamp': { $gte: ?0 }, 'type': ?1 }")
    List<Transaction> findTransactionsByTypeInLast24Hours(LocalDateTime fromTime, String type);

}
