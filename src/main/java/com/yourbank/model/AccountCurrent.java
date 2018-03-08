package com.yourbank.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("AC")
public class AccountCurrent extends Account
{
	private double overdraft;
	
	
	public AccountCurrent() {
		// TODO Auto-generated constructor stub
	}




	public AccountCurrent(String codeAccount, Date dateCreation, double amount, Client client, double overdraft) {
		super(codeAccount, dateCreation, amount, client);
		this.overdraft = overdraft;
	}




	public double getOverdraft() {
		return overdraft;
	}


	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	

}
