package com.kinective.atm.application.transaction.service;

import com.kinective.atm.domain.entities.transaction.Transaction;
import com.kinective.atm.infrastructure.transactionRepository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Pradeep Kushwah
 */

@RequiredArgsConstructor
@Service
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    /**
     * @return the List of all transactions.
     */
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    /**
     * @param transaction transactionObject
     * @return it provides the objects which is created in persistence store.
     */
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    /**
     * Find transaction by id
     *
     * @param id the transaction id
     * @return the Transaction entity.
     */
    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
    }


    public long countTransactionsInLast24Hours() {

        LocalDateTime fromTime = LocalDateTime.now().minusHours(24);
        List<Transaction> transactions = transactionRepository.findTransactionsInLast24Hours(fromTime);
        return transactions.size();
    }


    public long countTransactionsByTypeInLast24Hours(String type) {
        LocalDateTime fromTime = LocalDateTime.now().minusHours(24);
        List<Transaction> transactions = transactionRepository.findTransactionsByTypeInLast24Hours(fromTime, type);
        return transactions.size();
    }
}
