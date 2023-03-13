package com.luv2code.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CostumerRepository;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
private CostumerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CostumerRepository customerRespository) {
		this.customerRepository = customerRespository;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public Customer saveCustomer(Customer theCustomer) {
		Customer customer = customerRepository.save(theCustomer);
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		Optional<Customer> result = customerRepository.findById(theId);

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
		
		customerRepository.deleteById(theId);
	}
	
	//Obtener por email: 
	@Transactional
	public Customer getCustomerByEmail(String email) {
		
		Customer customer = customerRepository.findByEmail(email);

        return customer;
	}
	
	
}





