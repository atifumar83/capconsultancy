package come.bank.app.service;

import java.util.List;

import com.bank.app.models.Account;

public interface IAccount {

	public Account openAccount(Account account);
	
	public List<Account> searchAccounts(String customerId);

	
}
