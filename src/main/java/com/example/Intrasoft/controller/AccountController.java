package com.example.Intrasoft.controller;

import com.example.Intrasoft.data.Account;
import com.example.Intrasoft.data.Beneficiary;
import com.example.Intrasoft.service.AccountService;
import com.example.Intrasoft.service.BeneficiaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/accounts")
@Tag(name = "Account", description = "basic operations for account")
public class AccountController {

    @Autowired
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
