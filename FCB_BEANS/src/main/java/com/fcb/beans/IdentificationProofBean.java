/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.beans;

import java.io.Serializable;

public class IdentificationProofBean implements Serializable {

	private Integer identificationProofId;
	private String proofType;
	private String proofIdNumber;

	/**
	 * @return the identificationProofId
	 */
	public Integer getIdentificationProofId() {
		return identificationProofId;
	}

	/**
	 * @param identificationProofId
	 *            the identificationProofId to set
	 */
	public void setIdentificationProofId(Integer identificationProofId) {
		this.identificationProofId = identificationProofId;
	}

	/**
	 * @return the proofType
	 */
	public String getProofType() {
		return proofType;
	}

	/**
	 * @param proofType
	 *            the proofType to set
	 */
	public void setProofType(String proofType) {
		this.proofType = proofType;
	}

	/**
	 * @return the proofIdNumber
	 */
	public String getProofIdNumber() {
		return proofIdNumber;
	}

	/**
	 * @param proofIdNumber
	 *            the proofIdNumber to set
	 */
	public void setProofIdNumber(String proofIdNumber) {
		this.proofIdNumber = proofIdNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IdentificationProofBean [identificationProofId=" + identificationProofId + ", proofType=" + proofType
				+ ", proofIdNumber=" + proofIdNumber + "]";
	}

}
