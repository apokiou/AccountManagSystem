package com.example.Intrasoft.service;

import com.example.Intrasoft.data.Account;
import com.example.Intrasoft.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class AccountService {

    @Autowired
    private final AccountRepository repository;



    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }



    public List<Account> getAccountsByBeneficiaryId(Long beneficiaryId) {
        return repository.findByBeneficiaryId(beneficiaryId);
    }

    public Double getAccountBalance(Long accountId) {
        Optional<Account> accountOptional = repository.findById(accountId);
        if (accountOptional.isPresent()) {
            return accountOptional.get().getBalance();
        } else {
            throw new RuntimeException("Account not found");
        }
    }



}
