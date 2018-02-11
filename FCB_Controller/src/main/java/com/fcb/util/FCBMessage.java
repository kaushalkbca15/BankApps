package com.fcb.util;

import com.fcb.entity.Account;

public class FCBMessage {
	public static String getMessage(Account account,String tracsactionTypeMessage) {
		return account.getBalance() + "  amount is "+tracsactionTypeMessage+" into account xxxxxxxx"
				+ account.getAccountNumber().toString().substring(account.getAccountNumber().toString().length() - 4,
						account.getAccountNumber().toString().length());
	}

	public static String getMessageSubject() {
		return "ANZ Transaction Alert";
	}
}
