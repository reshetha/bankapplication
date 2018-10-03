package com.capgemini.bankapplication.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapplication.entities.BankAccount;
import com.capgemini.bankapplication.entities.Customer;
import com.capgemini.bankapplication.repository.CustomerRepository;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customer authenticate(Customer customer) {
		
		return jdbcTemplate.queryForObject(
				"select * from customers inner join bankaccounts on bankaccounts.customerid=customers.customerid where customers.customerid=? and customers.customerpassword=?",
				new Object[] { customer.getCustomerId(), customer.getPassword() }, new CustomerRowMapper());

	}

	@Override
	public Customer updateProfile(Customer customer) {
		int count = jdbcTemplate.update(
				"update customers set customername=?,customeraddress=?,customeremail=? where customerid=?",
				new Object[] { customer.getCustomerName(), customer.getAddress(), customer.getEmail(),
						customer.getCustomerId() });
		if (count != 0) {
			return customer;
		} else {
			return getCustomer(customer.getCustomerId());
		}
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		int count = jdbcTemplate.update("update customers set customerpassword=? where customerid=?",
				new Object[] { newPassword, customer.getCustomerId() });
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	class CustomerRowMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

			Customer customer = new Customer();

			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setPassword(rs.getString(4));
			customer.setEmail(rs.getString(3));
			customer.setAddress(rs.getString(5));
			customer.setDateOfBirth(rs.getDate(6).toLocalDate());
			
			BankAccount account = new BankAccount(rs.getLong(8), rs.getString(9), rs.getDouble(10));
			customer.setAccount(account);
			return customer;
			
			
		}

	}
	public Customer getCustomer(int customerId) {
		
		return jdbcTemplate.queryForObject(
				"select * from customers inner join bankaccounts on bankaccounts.customerid=customers.customerid where customers.customerid=?",
				new Object[] { customerId }, new CustomerRowMapper());

	}
}
