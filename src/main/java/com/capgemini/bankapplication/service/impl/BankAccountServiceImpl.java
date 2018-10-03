package com.capgemini.bankapplication.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.bankapplication.repository.BankAccountRepository;
import com.capgemini.bankapplication.service.BankAccountService;
@Service
public  class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;
	@Autowired
	BankAccountServiceImpl serviceobject;

	@Override
	public double getBalance(long accountId) {
		return bankAccountRepository.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) {
		double accountBalance = bankAccountRepository.getBalance(accountId);
		bankAccountRepository.updateBalance(accountId, accountBalance - amount);
		return accountBalance - amount;
	}

	@Override
	public double deposit(long accountId, double amount) {
		double accountBalance = bankAccountRepository.getBalance(accountId);
		bankAccountRepository.updateBalance(accountId, accountBalance + amount);
		return accountBalance + amount;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) {
		double balance = withdraw(fromAcc,amount);
		if(balance !=0) {
			if(deposit(toAcc,amount)== -1) {
				deposit(fromAcc,amount);
				return false;
			}
			return true;
		}
		return false;
		
		
	}
	
	}




