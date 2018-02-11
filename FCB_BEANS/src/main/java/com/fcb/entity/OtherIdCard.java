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
@Table(name="OTHER_ID_CARD",schema = "FCBDB")
public class OtherIdCard {
	@Id
	@GenericGenerator(name="otherCardIdGenerator",strategy = "increment")
	@GeneratedValue(generator = "otherCardIdGenerator")
	@Column(name="OTHER_CARD_ID")
	private Integer otherCardId;

	@Column(name = "ID_CARD_TYPE")
	private String idCardType;

	@Column(name="ID_CARD_NUMBER")
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

}
