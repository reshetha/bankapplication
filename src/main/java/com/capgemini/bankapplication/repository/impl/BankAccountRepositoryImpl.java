package com.capgemini.bankapplication.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapplication.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBalance(long accountId) {
		double c= jdbcTemplate.queryForObject("SELECT balance FROM bankaccounts Where account_id=?",
				new Object[] { accountId }, Double.class);
		return c;

	}

	@Override
	public double updateBalance(long accountId, double newBalance) {
		double balance = jdbcTemplate.update("update bankaccounts set balance=? where account_id=?",
				new Object[] { newBalance, accountId });
		return getBalance(accountId);
	}
}
	
	

	



