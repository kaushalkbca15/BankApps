package com.fcb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Card_Tpe", schema = "FCBDB")
public class CardType {
	@Id
	@Column(name = "card_type_id")
	@GeneratedValue(generator = "cardTypeIdGenerator")
	@GenericGenerator(name = "cardTypeIdGenerator", strategy = "increment")
	private Integer cardTypeId;
	@Column(name = "card_type_name")
	private String cardTypeName;
	@ManyToOne
	@JoinColumn(name = "payment_system_id")
	private PaymentSystem paymentSystem;

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
	public PaymentSystem getPaymentSystem() {
		return paymentSystem;
	}

	/**
	 * @param paymentSystem
	 *            the paymentSystem to set
	 */
	public void setPaymentSystem(PaymentSystem paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

}
