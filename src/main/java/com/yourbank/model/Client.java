package com.yourbank.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Client implements Serializable
{
	@Id
	@GeneratedValue
	private Long code;
	private  String name;
	private String email;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Account> account;
	
	
	public Client() {
		// TODO Auto-generated constructor stub
	}


	public Client(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Account> getAccount() {
		return account;
	}


	public void setAccount(Collection<Account> account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Client [code=" + code + ", name=" + name + ", email=" + email + ", account=" + account + "]";
	}
	
	
	

}
