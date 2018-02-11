/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.beans;

import java.io.Serializable;
import java.util.Date;

public class PassportDetailsBean implements Serializable {
	private Integer passportDetailsId;
	private String passportNumber;
	private String passportIssuedDate;
	private String passportExpiryDate;
	private String issuedPlace;
	/**
	 * @return the passportDetailsId
	 */
	public Integer getPassportDetailsId() {
		return passportDetailsId;
	}
	/**
	 * @param passportDetailsId the passportDetailsId to set
	 */
	public void setPassportDetailsId(Integer passportDetailsId) {
		this.passportDetailsId = passportDetailsId;
	}
	/**
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}
	/**
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	/**
	 * @return the passportIssuedDate
	 */
	public String getPassportIssuedDate() {
		return passportIssuedDate;
	}
	/**
	 * @param passportIssuedDate the passportIssuedDate to set
	 */
	public void setPassportIssuedDate(String passportIssuedDate) {
		this.passportIssuedDate = passportIssuedDate;
	}
	/**
	 * @return the passportExpiryDate
	 */
	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}
	/**
	 * @param passportExpiryDate the passportExpiryDate to set
	 */
	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}
	/**
	 * @return the issuedPlace
	 */
	public String getIssuedPlace() {
		return issuedPlace;
	}
	/**
	 * @param issuedPlace the issuedPlace to set
	 */
	public void setIssuedPlace(String issuedPlace) {
		this.issuedPlace = issuedPlace;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PassportDetailsBean [passportDetailsId=" + passportDetailsId + ", passportNumber=" + passportNumber
				+ ", passportIssuedDate=" + passportIssuedDate + ", passportExpiryDate=" + passportExpiryDate
				+ ", issuedPlace=" + issuedPlace + "]";
	}

	
	
}
