package com.yourbank;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yourbank.dao.AccountRepository;
import com.yourbank.dao.ClientRepository;
import com.yourbank.dao.OperationRepository;
import com.yourbank.model.Account;
import com.yourbank.model.AccountCurrent;
import com.yourbank.model.AccountSaving;
import com.yourbank.model.Client;
import com.yourbank.model.Payment;
import com.yourbank.model.Withdraw;
import com.yourbank.service.BankServiceI;

@SpringBootApplication
public class YourBankApplication implements CommandLineRunner
{
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	private BankServiceI bankService;

	public static void main(String[] args) 
	{
          SpringApplication.run(YourBankApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception 
	{
       /* Client c1=clientRepository.save(new Client("clientRam","clientR@gmail.com"));
		Client c2=clientRepository.save(new Client("clientShyam","clientS@gmail.com"));
		
		
		Account ac1=accountRepository.save(new AccountCurrent("c1",new Date(),5000, c1,900));
		Account ac2=accountRepository.save(new AccountSaving("c2",new Date(),5000, c2,10));
		
		
		operationRepository.save(new Payment(new Date(),470, ac1));
		operationRepository.save(new Payment(new Date(),1000, ac1));
		operationRepository.save(new Payment(new Date(),15000, ac1));
		operationRepository.save(new Payment(new Date(),1000, ac2));
		operationRepository.save(new Withdraw(new Date(),1000, ac2));
		
		bankService.pay("c1",9977);  */
		
		
	}
}
