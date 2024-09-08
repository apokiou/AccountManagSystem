package com.example.Intrasoft.service;

import com.example.Intrasoft.data.Account;
import com.example.Intrasoft.data.Beneficiary;
import com.example.Intrasoft.data.Transaction;
import com.example.Intrasoft.repo.AccountRepository;
import com.example.Intrasoft.repo.BeneficiaryRepository;
import com.example.Intrasoft.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoaderService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void loadBeneficiariesFromCSV(String filePath) {
        List<String[]> rows = readCSV(filePath);
        for (String[] row : rows) {
            try {
                Long id = Long.parseLong(row[0]); // Assuming ID is in the first column
                String name = row[1]; // Assuming name is in the second column
                Beneficiary beneficiary = new Beneficiary();
                beneficiary.setId(id);
                beneficiary.setFirstName(name);
                beneficiaryRepository.save(beneficiary);
            } catch (NumberFormatException e) {
                System.err.println("Invalid numeric value: " + row[0]);
            }
        }
    }

    public void loadAccountsFromCSV(String filePath) {
        List<String[]> rows = readCSV(filePath);
        for (String[] row : rows) {
            try {
                Long id = Long.parseLong(row[0]);
                String accountName = row[1];
                Account account = new Account();
                account.setId(id);
                accountRepository.save(account);
            } catch (NumberFormatException e) {
                System.err.println("Invalid numeric value: " + row[0]);
            }
        }
    }

    public void loadTransactionsFromCSV(String filePath) {
        List<String[]> rows = readCSV(filePath);
        for (String[] row : rows) {
            try {
                Long accountId = Long.parseLong(row[0]);
                Double amount = Double.parseDouble(row[1]);
                String transactionType = row[2];
                Transaction transaction = new Transaction();
                transaction.setAmount(accountId.doubleValue());
                transaction.setAmount(amount);
                transaction.setType(transactionType);
                transactionRepository.save(transaction);
            } catch (NumberFormatException e) {
                System.err.println("Invalid numeric value: " + row[0] + " or " + row[1]);
            }
        }
    }

    private List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
