package com.yourbank.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("WD")
public class Withdraw extends Operate
{
	
	public Withdraw() {
		// TODO Auto-generated constructor stub
	}

	public Withdraw(Date dateCreation, double amount, Account account) {
		super(dateCreation, amount, account);
		// TODO Auto-generated constructor stub
	}

	

}
