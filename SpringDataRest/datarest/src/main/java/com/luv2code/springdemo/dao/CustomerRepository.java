package com.luv2code.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springdemo.entity.Customer;

@RepositoryRestResource(path="clientes")
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
}
