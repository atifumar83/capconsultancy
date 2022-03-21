package com.bank.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {

	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transactionId;
	

	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "BALANCE")
	private Double balance;
	@Column(name = "TRANSACTION_DATE")
	private long transactionDate= System.currentTimeMillis();
	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;
	
    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;
	

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public long getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(long transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
