package com.example.Intrasoft.service;

import com.example.Intrasoft.data.Transaction;
import com.example.Intrasoft.repo.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return repository.findByAccountId(accountId);
    }

    public Optional<Transaction> getLargestWithdrawalInLastMonth(Long accountId) {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        return repository
                .findByAccountIdAndTypeAndTransactionDateAfter(accountId, "withdrawal", oneMonthAgo)
                .stream()
                .max(Comparator.comparingDouble(Transaction::getAmount));
    }
}
