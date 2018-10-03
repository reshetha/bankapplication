
package com.capgemini.bankapplication.service.impl; 
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankapplication.entities.Customer;
import com.capgemini.bankapplication.repository.CustomerRepository;
import com.capgemini.bankapplication.repository.impl.CustomerRepositoryImpl;
import com.capgemini.bankapplication.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer authenticate(Customer customer)  {
		
		return customerRepository.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer)  {
		return customerRepository.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword)  {
		return customerRepository.updatePassword(customer, oldPassword, newPassword);
	}
	
	
	}


