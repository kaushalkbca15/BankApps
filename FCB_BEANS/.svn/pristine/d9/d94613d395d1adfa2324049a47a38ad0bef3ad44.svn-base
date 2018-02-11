package com.fcb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "card", schema = "FCBDB")
public class Card {
	@Id
	@Column(name = "card_id")
	@GeneratedValue(generator = "cardIdGenerator")
	@GenericGenerator(name = "cardIdGenerator", strategy = "increment")
	private Integer cardId;
	@Column(name = "card_number")
	private Long cardNumber;
	@Column(name = "expiry_date")
	private Date expiryDate;
	@Column(name = "cvv")
	private Integer cvv;
	@ManyToOne
	@JoinColumn(name = "card_type_id")
	private CardType cardType;

	/**
	 * @return the cardId
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * @param cardId
	 *            the cardId to set
	 */
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the cardNumber
	 */
	public Long getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the cvv
	 */
	public Integer getCvv() {
		return cvv;
	}

	/**
	 * @param cvv
	 *            the cvv to set
	 */
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

}
