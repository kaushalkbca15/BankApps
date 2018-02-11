/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.fcb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name="Bank",schema="FCBDB")
public class Bank implements Serializable {
	
	@Id
	@Column(name="bank_id")
	@GenericGenerator(name="bankIdGenerator",strategy="increment")
	@GeneratedValue(generator="bankIdGenerator")
	private Integer bankId;
	@Column(name="bank_name")
	private String bankName;
	@Column(name="bank_type")
	private String bankType;

	/**
	 * @return the bankId
	 */
	public Integer getBankId() {
		return bankId;
	}

	/**
	 * @param bankId
	 *            the bankId to set
	 */
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 *            the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the bankType
	 */
	public String getBankType() {
		return bankType;
	}

	/**
	 * @param bankType
	 *            the bankType to set
	 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

}
