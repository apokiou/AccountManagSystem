package com.example.Intrasoft.controller;

import com.example.Intrasoft.data.Account;
import com.example.Intrasoft.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/beneficiary/{beneficiaryId}")
    public List<Account> getAccountsForBeneficiary(@PathVariable Long beneficiaryId) {
        return service.getAccountsByBeneficiaryId(beneficiaryId);
    }

    @GetMapping("/{id}/balance")
    public Double getAccountBalance(@PathVariable Long id) {
        return service.getAccountBalance(id);
    }
}
