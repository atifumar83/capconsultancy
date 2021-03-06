package com.bank.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.app.models.Account;
import com.bank.app.models.Transactions;

import come.bank.app.service.IAccount;
import come.bank.app.service.ICustomer;
import come.bank.app.service.ITransactions;

@Controller
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private IAccount accountService;
		
	@Autowired
	private ITransactions transactionService;


	@RequestMapping(path ="/" , method = RequestMethod.POST)	
	public ResponseEntity<Account> openAccount(@RequestBody Account account) {
		return new ResponseEntity<>(accountService.openAccount(account), HttpStatus.OK);
	}

	@RequestMapping(path ="/{customerId}" , method = RequestMethod.GET)	
	public ResponseEntity<List<Account>> findAccountByCustomer(@PathVariable String customerId) {
		return new ResponseEntity<>(accountService.searchAccounts(customerId), HttpStatus.OK);
	}
	@RequestMapping(path ="/summery/{customerId}" , method = RequestMethod.GET)	
	public ResponseEntity<List<Transactions>> findAllTransactions(@PathVariable String customerId) {
		return new ResponseEntity<>(transactionService.findByAccountAndCustomer(customerId), HttpStatus.OK);
	}
}
