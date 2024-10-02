package com.kinective.atm.application.transaction.controller;

import com.kinective.atm.application.transaction.service.TransactionService;
import com.kinective.atm.domain.entities.transaction.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pradeep Kushwah
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/atm/transactions")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;


    @Operation(summary = "it is used get all Transactions ",
            description = "it is used get all Transactions ")
    @ApiResponse(responseCode = "200", description = "Returns success if all transaction found successfully.")
    @GetMapping("fetch/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }


    @Operation(summary = "it is used create Transaction ",
            description = "it is used create Transaction ")
    @ApiResponse(responseCode = "200", description = "Returns success if transaction created successfully.")
    @PostMapping("/register")
    public ResponseEntity<Transaction> createTransaction(
            @Parameter(description = "transaction request boyd", required = true)
            @RequestBody Transaction transaction) {

        //TODO:transaction request body validation

        Transaction newTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }


    @Operation(summary = "it is used get transaction by id ",
            description = "it is used get transaction by id ")
    @ApiResponse(responseCode = "200", description = "Returns success if transaction found by id successfully.")
    @GetMapping("/fetch/{id}")
    public ResponseEntity<Transaction> getTransactionById(
            @Parameter(description = "transaction id", required = true)
            @PathVariable String id) {
        Transaction transaction = transactionService.getTransactionById(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }


    @Operation(summary = "it is used to get all transaction in last 24 hours ",
            description = "it is used to get all transaction in last 24 hours ")
    @ApiResponse(responseCode = "200", description = "Returns success if transaction found successfully.")
    @GetMapping("/last24hours/count")
    public long getTransactionCountInLast24Hours() {
        return transactionService.countTransactionsInLast24Hours();
    }


    @Operation(summary = "it is used to get all transaction in last 24 hours using type of transaction ",
            description = "it is used to get all transaction in last 24 hours using type of transaction  ")
    @ApiResponse(responseCode = "200", description = "Returns success if transaction in last 24 hours using type of transaction found successfully.")
    @GetMapping("/last24hours/countByType")
    public long getTransactionCountByTypeInLast24Hours(
            @Parameter(description = "transaction type", required = true)
            @RequestParam String type) {
        return transactionService.countTransactionsByTypeInLast24Hours(type);
    }
}
