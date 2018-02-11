
/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


public class AccountTransactionsBean implements Serializable{
	private Integer transactionId;
	private Date transactionDate;

	private AccountBean account;

	private Double transactionAmount;
	private String transactionMode;
	private String transactionType;
	private String chequeeOrddNumber;
	private String chequeeOrddIssuedBy;
	private Date chequeeOrddIssuedDate;
	private String transactionStatus;
	private Integer createdBy;	
	private Timestamp createdDate;
	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	/**
	 * @return the account
	 */
	public AccountBean getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(AccountBean account) {
		this.account = account;
	}
	/**
	 * @return the transactionAmount
	 */
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	/**
	 * @return the transactionMode
	 */
	public String getTransactionMode() {
		return transactionMode;
	}
	/**
	 * @param transactionMode the transactionMode to set
	 */
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the chequeeOrddNumber
	 */
	public String getChequeeOrddNumber() {
		return chequeeOrddNumber;
	}
	/**
	 * @param chequeeOrddNumber the chequeeOrddNumber to set
	 */
	public void setChequeeOrddNumber(String chequeeOrddNumber) {
		this.chequeeOrddNumber = chequeeOrddNumber;
	}
	/**
	 * @return the chequeeOrddIssuedBy
	 */
	public String getChequeeOrddIssuedBy() {
		return chequeeOrddIssuedBy;
	}
	/**
	 * @param chequeeOrddIssuedBy the chequeeOrddIssuedBy to set
	 */
	public void setChequeeOrddIssuedBy(String chequeeOrddIssuedBy) {
		this.chequeeOrddIssuedBy = chequeeOrddIssuedBy;
	}
	/**
	 * @return the chequeeOrddIssuedDate
	 */
	public Date getChequeeOrddIssuedDate() {
		return chequeeOrddIssuedDate;
	}
	/**
	 * @param chequeeOrddIssuedDate the chequeeOrddIssuedDate to set
	 */
	public void setChequeeOrddIssuedDate(Date chequeeOrddIssuedDate) {
		this.chequeeOrddIssuedDate = chequeeOrddIssuedDate;
	}
	/**
	 * @return the transactionStatus
	 */
	public String getTransactionStatus() {
		return transactionStatus;
	}
	/**
	 * @param transactionStatus the transactionStatus to set
	 */
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
