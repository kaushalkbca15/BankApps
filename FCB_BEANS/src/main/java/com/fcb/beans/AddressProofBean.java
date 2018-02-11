/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.beans;


public class AddressProofBean {
    private Integer addressProofId;
    private String proofType;
    private String proofIdNumber;

    /**
     * @return the addressProofId;
     */
    public Integer getAddressProofId() {
        return addressProofId;
    }

    /**
     * @param addressProofId the addressProofId to set
     */
    public void setAddressProofId(Integer addressProofId) {
        this.addressProofId = addressProofId;
    }

    /**
     * @return the proofType;
     */
    public String getProofType() {
        return proofType;
    }

    /**
     * @param proofType the proofType to set
     */
    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    /**
     * @return the proofIdNumber;
     */
    public String getProofIdNumber() {
        return proofIdNumber;
    }

    /**
     * @param proofIdNumber the proofIdNumber to set
     */
    public void setProofIdNumber(String proofIdNumber) {
        this.proofIdNumber = proofIdNumber;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressProofBean [addressProofId=" + addressProofId + ", proofType=" + proofType + ", proofIdNumber="
				+ proofIdNumber + "]";
	}
    
}
