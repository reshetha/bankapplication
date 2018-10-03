package com.capgemini.bankapplication.service;



public interface BankAccountService {
	
	public double getBalance(long accountId);
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) ;
	double withdraw(long accountId, double amount);
    double deposit(long accountId, double amount) ; 
}
