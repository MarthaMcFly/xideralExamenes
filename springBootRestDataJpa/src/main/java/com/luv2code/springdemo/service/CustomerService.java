package com.luv2code.springdemo.service;

import java.util.List;
import java.util.Optional;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public Customer getCustomerByEmail(String email);
	
	
}
