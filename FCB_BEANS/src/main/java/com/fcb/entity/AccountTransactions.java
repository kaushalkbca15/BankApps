
/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 *
 * @author sathish
 * @since FCB 1.0
 */
@Entity
@Table(name = "ACCOUNT_TRANSACTIONS",schema = "FCBDB")
public class AccountTransactions {
	@Id
	@GenericGenerator(name="accountTransactionsIdGenerator",strategy = "increment")
	@GeneratedValue(generator = "accountTransactionsIdGenerator")
	@Column(name="TRANSACTION_ID")
	private Integer transactionId;
	@Column(name = "TRANSACTION_DATE")
	private Date transactionDate;

	@JoinColumn(name = "ACCOUNT_NUMBER")
	@ManyToOne
	private Account account;

	@Column(name = "TRANSACTION_AMOUNT")
	private Double transactionAmount;
	@Column(name = "TRANSACTION_MODE")
	private String transactionMode;
	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;
	@Column(name = "CHEQUEEORDD_NUMBER")
	private String chequeeOrddNumber;
	@Column(name = "CHEQUEEORDD_ISSUED_BY")
	private String chequeeOrddIssuedBy;
	@Column(name = "CHEQUEEORDD_ISSUED_DATE")
	private Date chequeeOrddIssuedDate;
	@Column(name = "TRANSACTION_STATUS")
	private String transactionStatus;
	@Column(name="CREATED_BY")
	private Integer createdBy;	
	@Column(name="CREATED_DATE")
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
	public Account getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
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
