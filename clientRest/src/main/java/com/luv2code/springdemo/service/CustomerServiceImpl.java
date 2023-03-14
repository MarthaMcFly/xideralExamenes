package com.luv2code.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public CustomerServiceImpl(RestTemplate theRestTemplate,
			@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url="+ crmRestUrl);
	}

	@Override
	public List<Customer> getCustomers() {

		logger.info("in getCustomers(): Calling REST API "+ crmRestUrl);

		// make REST call

		ResponseEntity<List<Customer>> responseEntity =
				restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Customer>>() {});

		// get the list of customers from response

		List<Customer> customers = responseEntity.getBody();

		logger.info("in getCustomers(): customers" + customers);

		return customers;	
	
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

	}

	@Override
	public Customer getCustomer(int theId) {

		return null;
	}

	@Override
	public void deleteCustomer(int theId) {

	}
}
