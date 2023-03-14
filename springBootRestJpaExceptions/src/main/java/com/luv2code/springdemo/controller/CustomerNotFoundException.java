package com.luv2code.springdemo.controller;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException (String message) {
		super(message);
	}
	
}
