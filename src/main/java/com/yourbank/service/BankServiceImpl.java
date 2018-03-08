package com.yourbank.service;

import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yourbank.dao.AccountRepository;
import com.yourbank.dao.OperationRepository;
import com.yourbank.model.Account;
import com.yourbank.model.AccountCurrent;
import com.yourbank.model.Operate;
import com.yourbank.model.Payment;
import com.yourbank.model.Withdraw;


@Service
@Transactional
public class BankServiceImpl implements BankServiceI
{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	

	@Override
	public Account consultAccount(String codeAccount) {
		Account account=accountRepository.findOne(codeAccount);
		if(account==null) throw new RuntimeException("Account not found!!!");
		return account;
	}

	@Override
	public void pay(String codeAccount, double amount) {
		Account account=consultAccount(codeAccount);
		Payment pay=new Payment(new Date(), amount, account);
		operationRepository.save(pay);
		account.setAmount(account.getAmount()+amount);
		accountRepository.save(account);
		
	}

	@Override
	public void remove(String codeAccount, double amount) {
		Account account=consultAccount(codeAccount);
		double facilitiesCheckout = 0;
		if(account instanceof AccountCurrent)
		{
			facilitiesCheckout=((AccountCurrent)account).getOverdraft();
		}
		if(account.getAmount() + facilitiesCheckout < amount)
			throw new RuntimeException("Amount insufficint");
		
		Withdraw withdraw=new Withdraw(new Date(), amount, account);
		operationRepository.save(withdraw);
		account.setAmount(account.getAmount()- amount);
		accountRepository.save(account);
	}

	@Override
	public void transfer(String codeAccount1, String codeAccount2, double amount) {
		if(codeAccount1.equals(codeAccount2))
			throw new RuntimeException("impossible trnasfer!!");
		remove(codeAccount1, amount);
		pay(codeAccount2, amount);
	}

	@Override
	public Page<Operate> listOperations(String codeAccount, int page, int size) {
		
		return operationRepository.listOperations(codeAccount,new PageRequest(page, size));
	}
	
	
	

}
