package com.bank.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.app.models.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String>{


	@Query(
			  value = "SELECT A FROM Account A JOIN FETCH A.customer c where c.customerId=?1")
	public List<Account> findAccountByCustomer(String customerId);
	
}
