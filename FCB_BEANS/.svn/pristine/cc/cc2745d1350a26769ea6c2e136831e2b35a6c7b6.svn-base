/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 *
 * @author sathish
 * @since FCB 1.0
 */
@Entity
@Table(name = "ACCOUNT",schema = "FCBDB")
public class Account {
	
	@Id
	@GenericGenerator(name="accountNumberIdGenerator",strategy = "increment")
	@GeneratedValue(generator = "accountNumberIdGenerator")
	@Column(name="ACCOUNT_NUMBER")
	private Long accountNumber;
	@Column(name="ACCOUNT_HOLDER_NAME")
	private String accountHolderName;
	@Column(name = "ACCOUNT_BALANCE")
	private Double balance;
	@Column(name = "ACCOUNT_STATUS")
	private Integer accountStatus;
	@Column(name = "ACCOUNT_OPENED_DATE")
	private Timestamp accountOpenedDate;
	@Column(name = "CREATED_BY")
	private Integer createdBy;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "UPDATED_BY")
	private Integer updatedBy;
	@Column(name = "UPDATED_DATE")
	private Timestamp updatedDate;
	
	@OneToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	
	@OneToOne
	@JoinColumn(name = "ACCOUNT_TYPE_ID")
	private AccountType accountType;
	
	
	@ManyToOne
	@JoinColumn(name = "BRANCH_ID")
	private Branch branch;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="ACCOUNT_ACTIVE_SERVICES",schema="FCBDB",
	joinColumns={@JoinColumn(name="account_number")},
	inverseJoinColumns={@JoinColumn(name="account_service_id")})
	private List<AccountServices> accountServicesList;

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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<AccountServices> getAccountServicesList() {
		return accountServicesList;
	}

	public void setAccountServicesList(List<AccountServices> accountServicesList) {
		this.accountServicesList = accountServicesList;
	}


}
