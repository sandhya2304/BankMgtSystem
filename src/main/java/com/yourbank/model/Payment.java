package com.yourbank.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("PAY")
public class Payment extends Operate
{
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Date dateCreation, double amount, Account account) {
		super(dateCreation, amount, account);
		// TODO Auto-generated constructor stub
	}

	
	

}
