package com.yourbank.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="OP",discriminatorType=DiscriminatorType.STRING,length=1)
public abstract class Operate implements Serializable
{
	@Id
	@GeneratedValue
	private Long noOperation;
	private Date dateCreation;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="CODE_ACT")
	private Account account;
	
	public Operate() {
		// TODO Auto-generated constructor stub
	}
	

	public Operate(Date dateCreation, double amount, Account account) {
		super();
		this.dateCreation = dateCreation;
		this.amount = amount;
		this.account = account;
	}

	public Long getNoOperation() {
		return noOperation;
	}

	public void setNoOperation(Long noOperation) {
		this.noOperation = noOperation;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

}
