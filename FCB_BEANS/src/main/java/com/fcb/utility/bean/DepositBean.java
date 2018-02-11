package com.fcb.utility.bean;

import java.util.Date;

public class DepositBean {
	
	private Long accountNumber;
	private Double amount;
	private String issuedDate;
	private String issuedBy;
	private Integer number;
	private String transactionMode;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	@Override
	public String toString() {
		return "DepositBean [accountNumber=" + accountNumber + ", amount=" + amount + ", issuedDate=" + issuedDate
				+ ", issuedBy=" + issuedBy + ", number=" + number + ", transactionMode=" + transactionMode + "]";
	}
	
	
}
