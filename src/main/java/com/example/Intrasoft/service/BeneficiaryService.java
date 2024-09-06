package com.example.Intrasoft.service;

import com.example.Intrasoft.data.Beneficiary;
import com.example.Intrasoft.repo.BeneficiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    private final BeneficiaryRepository repository;

    public BeneficiaryService(BeneficiaryRepository repository) {
        this.repository = repository;
    }

    public List<Beneficiary> getAllBeneficiaries() {
        return repository.findAll();
    }

    public Beneficiary getBeneficiaryById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
