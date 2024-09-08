package com.example.Intrasoft.repo;

import com.example.Intrasoft.data.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @EntityGraph(attributePaths = "beneficiary")
    List<Account> findByBeneficiaryId(Long beneficiaryId);
}