package com.yourbank.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yourbank.model.Operate;

public interface OperationRepository extends JpaRepository<Operate,Long>
{
	@Query("select o from Operate o where o.account.codeAccount=:x order by o.dateCreation desc")
	public Page<Operate> listOperations(@Param("x")String codeAccount,Pageable pageable);

}
