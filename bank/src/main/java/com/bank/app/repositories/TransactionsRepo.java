package com.bank.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.app.models.Transactions;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Integer>{

	@Query(
			  value = "SELECT * FROM TRANSACTIONS T WHERE T.TRANSACTION_TYPE = 'Deposit' AND T.ACCOUNT_ID=?1 ORDER BY T.TRANSACTION_DATE DESC LIMIT 1", 
			  nativeQuery = true)
	public Transactions findTransactionLatestByDate(String accountId);
	
	@Query(
			  value = "SELECT T FROM Transactions T JOIN FETCH T.account WHERE T.account.customer.customerId=?1")
	public List<Transactions> findTransaction(String accountId);
	
	
}
