package com.example.Intrasoft;

//import com.example.Intrasoft.service.DataLoaderService;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IntrasoftApplication  {

//	@Autowired
//	private DataLoaderService dataLoaderService;




	public static void main(String[] args) {
		SpringApplication.run(IntrasoftApplication.class, args);
	}


//	public void run(String... args) throws Exception {
//		dataLoaderService.loadBeneficiariesFromCSV("C:/Users/Android/Desktop/Nejava/beneficiaries.csv");
//		dataLoaderService.loadAccountsFromCSV("C:/Users/Android/Desktop/Nejava/accounts.csv");
//		dataLoaderService.loadTransactionsFromCSV("C:/Users/Android/Desktop/Nejava/transactions.csv");
//	}
}
