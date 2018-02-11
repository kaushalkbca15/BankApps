package com.fcb.dao;

import java.util.List;

import com.fcb.beans.AccountStatus;
import com.fcb.entity.Account;
import com.fcb.entity.AccountTransactions;

public interface AccountDAO {
	public AccountStatus accountStatus(Long accountNumber);

	public Double getBalance(Long accountNumber);

	public Integer deposit(Account account, AccountTransactions accountTransactions);

	public Integer withdraw(Account account, AccountTransactions accountTransactions);

	public List getBranchId();

}
