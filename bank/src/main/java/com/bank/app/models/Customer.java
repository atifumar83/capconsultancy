package com.bank.app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String customerId;
	
	@Column(name = "NAME")
	private String name;
	@Column(name = "PHONE")
	private String phone;
	
	@OneToMany(mappedBy="customer")
	private Set<Account> accounts;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	

}
