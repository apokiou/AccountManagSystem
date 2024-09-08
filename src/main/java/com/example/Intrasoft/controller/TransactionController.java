package com.example.Intrasoft.controller;

import com.example.Intrasoft.data.Transaction;
import com.example.Intrasoft.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactionsForAccount(@PathVariable Long accountId) {
        return service.getTransactionsByAccountId(accountId);
    }

    @GetMapping("/account/{accountId}/largest-withdrawal")
    public Transaction getLargestWithdrawalInLastMonth(@PathVariable Long accountId) {
        return service.getLargestWithdrawalInLastMonth(accountId).orElse(null);
    }
}
