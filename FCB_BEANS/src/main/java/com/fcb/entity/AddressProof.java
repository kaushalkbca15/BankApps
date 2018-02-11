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
@Table(name = "ADDRESS_PROOF",schema = "FCBDB")
public class AddressProof {
    @Id
    @GenericGenerator(name = "addressProofIdGenerator",strategy = "increment")
    @GeneratedValue(generator = "addressProofIdGenerator")
    @Column(name="ADDRESS_PROOF_ID")
    private Integer addressProofId;
    @Column(name="PROOF_TYPE")
    private String proofType;
    @Column(name="PROOF_ID_NUMBER")
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
		return "AddressProof [addressProofId=" + addressProofId + ", proofType=" + proofType + ", proofIdNumber="
				+ proofIdNumber + "]";
	}
    
}
