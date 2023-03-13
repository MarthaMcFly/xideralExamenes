package com.luv2code.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerRepository;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRespository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRespository) {
		this.customerRespository = customerRespository;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerRespository.findAll();
	}

	@Override
	@Transactional
	public Customer saveCustomer(Customer theCustomer) {
		Customer customer = customerRespository.save(theCustomer);
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		Optional<Customer> result = customerRespository.findById(theId);

        Customer customer = null;

        if (result.isPresent()) {
        	customer = result.get();
        }
        else {
            // we didn't find the customer
            throw new RuntimeException("Did not find customer id - " + theId);
        }

        return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerRespository.deleteById(theId);
	}
	
	@Override
	@Transactional
	public Customer getCustomerByEmail(String email) {
		
        Customer customer = customerRespository.findByEmail(email);

        return customer;
	}
}





