package com.fcb.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

public class CardTypeBean {
	private Integer cardTypeId;
	private String cardTypeName;
	private PaymentSystemBean paymentSystem;

	/**
	 * @return the cardTypeId
	 */
	public Integer getCardTypeId() {
		return cardTypeId;
	}

	/**
	 * @param cardTypeId
	 *            the cardTypeId to set
	 */
	public void setCardTypeId(Integer cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	/**
	 * @return the cardTypeName
	 */
	public String getCardTypeName() {
		return cardTypeName;
	}

	/**
	 * @param cardTypeName
	 *            the cardTypeName to set
	 */
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	/**
	 * @return the paymentSystem
	 */
	public PaymentSystemBean getPaymentSystem() {
		return paymentSystem;
	}

	/**
	 * @param paymentSystem
	 *            the paymentSystem to set
	 */
	public void setPaymentSystem(PaymentSystemBean paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

}
