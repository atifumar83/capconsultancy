package come.bank.app.service;

import java.util.List;

import com.bank.app.models.Transactions;

public interface ITransactions {
	
	public Transactions saveTransaction(Transactions account);
	
	public Transactions findByAccount(String accountId);
	
	public List<Transactions> findByAccountAndCustomer(String customerId);

}
