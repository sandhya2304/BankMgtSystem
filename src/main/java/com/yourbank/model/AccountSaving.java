package com.yourbank.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("AS")
public class AccountSaving extends Account
{
	private double tax;
	
	
	public AccountSaving() {
		// TODO Auto-generated constructor stub
	}



	public AccountSaving(String codeAccount, Date dateCreation, double amount, Client client, double tax) {
		super(codeAccount, dateCreation, amount, client);
		this.tax = tax;
	}



	public double getTax() {
		return tax;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}
	
	

}
