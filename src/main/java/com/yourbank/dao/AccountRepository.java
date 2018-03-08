package com.yourbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourbank.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>
{

}
