package com.bank.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.models.Transactions;
import com.bank.app.repositories.TransactionsRepo;

import come.bank.app.service.ITransactions;

@Service
public class TransactionService implements ITransactions{

	@Autowired
	private TransactionsRepo transactionRepo;
	
	@Override
	public Transactions saveTransaction(Transactions transaction) {
		return transactionRepo.save(transaction);
	}

	@Override
	public Transactions findByAccount(String accountId) {
		// TODO Auto-generated method stub
		return transactionRepo.findTransactionLatestByDate(accountId);
	}

	@Override
	public List<Transactions> findByAccountAndCustomer(String customerId) {
		return transactionRepo.findTransaction(customerId);
	}

}
