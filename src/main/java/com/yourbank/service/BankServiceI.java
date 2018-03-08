package com.yourbank.service;

import org.springframework.data.domain.Page;

import com.yourbank.model.Account;
import com.yourbank.model.Operate;

public interface BankServiceI 
{
	
	public Account consultAccount(String codeAccount);
	public void pay(String codeAccount,double amount);
	public void remove(String codeAccount,double amount);
	public void transfer(String codeAccount1,String codeAccount2,double amount);
	public Page<Operate> listOperations(String codeAccount,int page,int size);
	

}
