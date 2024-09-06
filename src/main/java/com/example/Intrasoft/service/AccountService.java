package com.example.Intrasoft.service;

import com.example.Intrasoft.data.Account;
import com.example.Intrasoft.repo.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAccountsByBeneficiaryId(Long beneficiaryId) {
        return repository.findByBeneficiaryId(beneficiaryId);
    }

    public Double getAccountBalance(Long accountId) {
        return repository.findById(accountId)
                         .map(Account::getBalance)
                         .orElse(null);
    }
}
