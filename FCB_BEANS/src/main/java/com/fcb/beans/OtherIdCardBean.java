/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.beans;



import java.io.Serializable;
public class OtherIdCardBean implements Serializable {
	private Integer otherCardId;

	private String idCardType;
	private  String idCardNumber;
	/**
	 * @return the otherCardId
	 */
	public Integer getOtherCardId() {
		return otherCardId;
	}
	/**
	 * @param otherCardId the otherCardId to set
	 */
	public void setOtherCardId(Integer otherCardId) {
		this.otherCardId = otherCardId;
	}
	/**
	 * @return the idCardType
	 */
	public String getIdCardType() {
		return idCardType;
	}
	/**
	 * @param idCardType the idCardType to set
	 */
	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}
	/**
	 * @return the idCardNumber
	 */
	public String getIdCardNumber() {
		return idCardNumber;
	}
	/**
	 * @param idCardNumber the idCardNumber to set
	 */
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OtherIdCardBean [otherCardId=" + otherCardId + ", idCardType=" + idCardType + ", idCardNumber="
				+ idCardNumber + "]";
	}

}
