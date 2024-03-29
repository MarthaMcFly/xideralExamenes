package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.service.CustomerServiceImpl;

@RestController
@RequestMapping("/rest")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) throws Exception {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new Exception("Customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		
		Customer addCustomer = customerService.saveCustomer(theCustomer);
		
		return addCustomer; //regresa el customer que estamos dando de alta con su id
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		Customer Customer=customerService.saveCustomer(theCustomer);//recupera la información cambiada y la manda de regreso 
		
		return Customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		// throw exception if null
		
		if (tempCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id - " + customerId;
	}
	
	
	//Para encontrar por email: 
	@GetMapping("/customers/email/{email}")
	public Customer findByEmail(@PathVariable String email) {
		
		return customerService.getCustomerByEmail(email);
	}
	
	
}










