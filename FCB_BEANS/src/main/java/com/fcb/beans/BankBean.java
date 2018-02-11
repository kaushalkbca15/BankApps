/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.fcb.beans;

import java.io.Serializable;

public class BankBean implements Serializable {
	
	private Integer bankId;
	private String bankName;
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
