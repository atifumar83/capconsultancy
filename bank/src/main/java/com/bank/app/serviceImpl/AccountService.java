package com.bank.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.models.Account;
import com.bank.app.models.TransactionTypes;
import com.bank.app.models.Transactions;
import com.bank.app.repositories.AccountRepo;

import come.bank.app.service.IAccount;

@Service
public class AccountService implements IAccount{

	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private TransactionService transactionService;
	

	
	public Account openAccount(Account account) {
		Account newAccount=null;
		if(account.getAccountId()==null) {
			account.setAccountId("ACC#"+System.currentTimeMillis());
			newAccount = accountRepo.save(account);
		}else {
		 	Optional<Account> option = accountRepo.findById(account.getAccountId());
		 	if(option.isPresent()) {
			 	newAccount = option.get();
		 	}else {
				newAccount = accountRepo.save(account);
		 	}
		}
		if(account.getInitialCredit()!=null&&account.getInitialCredit()>0) {
			
			Transactions latestTransaction = transactionService.findByAccount(account.getAccountId());
			
			Transactions transaction = new Transactions();
			transaction.setAccount(newAccount);
			transaction.setAmount(newAccount.getInitialCredit());
			if(latestTransaction!=null)
			transaction.setBalance(account.getInitialCredit()+latestTransaction.getBalance());
			else
				transaction.setBalance(newAccount.getInitialCredit());
			transaction.setTransactionType(TransactionTypes.Deposit.toString());
			this.transactionService.saveTransaction(transaction);
		}
		return newAccount;
	}

	public List<Account> searchAccounts(String customerId) {
		return this.accountRepo.findAccountByCustomer(customerId);
	}

}
