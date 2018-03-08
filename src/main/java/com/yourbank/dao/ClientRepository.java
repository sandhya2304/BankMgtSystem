package com.yourbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourbank.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long>
{

}
