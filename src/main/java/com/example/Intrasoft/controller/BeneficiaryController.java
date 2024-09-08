package com.example.Intrasoft.controller;

import com.example.Intrasoft.data.Beneficiary;
import com.example.Intrasoft.service.BeneficiaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/beneficiaries")
public class BeneficiaryController {

    private final BeneficiaryService service;

    public BeneficiaryController(BeneficiaryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Beneficiary> getAllBeneficiaries() {
        return service.getAllBeneficiaries();
    }

    @GetMapping("/{id}")
    public Beneficiary getBeneficiary(@PathVariable Long id) {
        return service.getBeneficiaryById(id);
    }
}
