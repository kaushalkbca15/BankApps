/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 *
 * @author sathish
 * @since FCB 1.0
 */
@Entity
@Table(name = "IDENTIFICATION_PROOF", schema = "FCBDB")
public class IdentificationProof implements Serializable {

	@Id
	@GenericGenerator(name="IDENTIFICATION_PROOF_IDGenerator",strategy = "increment")
	@GeneratedValue(generator = "IDENTIFICATION_PROOF_IDGenerator")
	@Column(name="IDENTIFICATION_PROOF_ID")
	private Integer identificationProofId;

	@Column(name = "PROOF_TYPE")
	private String proofType;

	@Column(name = "PROOF_ID_NUMBER")
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
		return "IdentificationProof [identificationProofId=" + identificationProofId + ", proofType=" + proofType
				+ ", proofIdNumber=" + proofIdNumber + "]";
	}

}
