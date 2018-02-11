package com.fcb.service;

import com.fcb.utility.bean.DepositBean;

public interface AccountService {
	public String accountStatus(String accountNumber);

	public String getBalance(String accountNumber);

	public String deposit(DepositBean depositBean);

	public String withdraw(DepositBean depositBean);

	public String getbranchId();
}
