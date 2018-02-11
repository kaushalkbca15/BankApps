/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 *
 * @author sathish
 * @since FCB 1.0
 */
@Entity
@Table(name = "ACCOUNT_TYPE",schema = "FCBDB")
public class AccountType {
	
	
	@Id
	@GenericGenerator(name = "accountTypeIdGenerator",strategy = "increment")
	@GeneratedValue(generator = "accountTypeIdGenerator")
	@Column(name = "ACCOUNT_TYPE_ID")
	
	private Integer accountTypeId;
	@Column(name = "ACCOUNT_TYPE_NAME")
	private String accountTypeName;

	/*@OneToOne(mappedBy="accountType",cascade=CascadeType.ALL)
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	*//**
	 * @return the accountTypeId
	 *//*
	public Integer getAccountTypeId() {
		return accountTypeId;
	}*/
	/**
	 * @param accountTypeId the accountTypeId to set
	 */
	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	/**
	 * @return the accountTypeName
	 */
	public String getAccountTypeName() {
		return accountTypeName;
	}
	/**
	 * @param accountTypeName the accountTypeName to set
	 */
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
}
