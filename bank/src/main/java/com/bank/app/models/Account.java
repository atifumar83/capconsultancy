package com.bank.app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

//	@Column(name = "CUSTOMER_ID")
//	private String customerId;
	
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
	
	@OneToMany(mappedBy="account")
	private Set<Transactions> transactions;
    
	@Id
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	@Column(name = "INITIAL_CREDIT")
	private Double initialCredit;
	

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Double getInitialCredit() {
		return initialCredit;
	}
	public void setInitialCredit(Double initialCredit) {
		this.initialCredit = initialCredit;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
