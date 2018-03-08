package com.yourbank.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ACCT",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Account implements Serializable
{
	@Id
	
	  private String codeAccount;
	  private Date dateCreation;
	  private double amount;
	  
	  @ManyToOne
	  @JoinColumn(name="Code_CLT")
	  private Client client;
	  @OneToMany(mappedBy="account",fetch=FetchType.LAZY)
	  private Collection<Operate> operation;
	  
	  public Account() {
		// TODO Auto-generated constructor stub
	}

	

	public Account(String codeAccount, Date dateCreation, double amount, Client client) {
		super();
		this.codeAccount = codeAccount;
		this.dateCreation = dateCreation;
		this.amount = amount;
		this.client = client;
	}



	public String getCodeAccount() {
		return codeAccount;
	}

	public void setCodeAccount(String codeAccount) {
		this.codeAccount = codeAccount;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Operate> getOperation() {
		return operation;
	}

	public void setOperation(Collection<Operate> operation) {
		this.operation = operation;
	}
	  
	  
	

}