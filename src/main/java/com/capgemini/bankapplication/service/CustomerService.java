package com.capgemini.bankapplication.service;

import java.sql.SQLException;

import com.capgemini.bankapplication.entities.Customer;

public interface CustomerService {

	public Customer authenticate(Customer customer) ;
	public Customer updateProfile(Customer customer) ;
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) ;
	
}
	

