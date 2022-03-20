package com.bank.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.models.Account;
import com.bank.app.repositories.CustomersRepo;

import come.bank.app.service.ICustomer;

@Service
public class CustomerServiceImpl implements ICustomer{

	@Autowired
	private CustomersRepo customerRepo;
	

}
