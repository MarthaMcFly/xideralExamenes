package com.luv2code.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springdemo.entity.Customer;

public interface CostumerRepository extends JpaRepository<Customer,Integer>{
	
	Customer findByEmail(String email);

}
