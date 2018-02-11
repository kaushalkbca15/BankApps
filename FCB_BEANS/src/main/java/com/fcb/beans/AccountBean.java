/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class AccountBean implements Serializable{

	private Long accountNumber;

	private String accountHolderName;

	private Double balance;

	private Integer accountStatus;

	private Timestamp accountOpenedDate;
	private Integer createdBy;
	private String createdDate;
	private Integer updatedBy;
	private Timestamp updatedDate;

	private CustomerBean customer;

	private AccountTypeBean accountType;

	private BranchBean branch;

	private List<AccountServicesBean> accountServicesList;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Timestamp getAccountOpenedDate() {
		return accountOpenedDate;
	}

	public void setAccountOpenedDate(Timestamp accountOpenedDate) {
		this.accountOpenedDate = accountOpenedDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}



	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

	public AccountTypeBean getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeBean accountType) {
		this.accountType = accountType;
	}

	public BranchBean getBranch() {
		return branch;
	}

	public void setBranch(BranchBean branch) {
		this.branch = branch;
	}

	public List<AccountServicesBean> getAccountServicesList() {
		return accountServicesList;
	}

	public void setAccountServicesList(List<AccountServicesBean> accountServicesList) {
		this.accountServicesList = accountServicesList;
	}

}
