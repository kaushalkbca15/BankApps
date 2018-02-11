package com.fcb.beans;

import java.util.Date;


import org.hibernate.annotations.GenericGenerator;

public class CardBean {
	private Integer cardId;
	private Long cardNumber;
	private Date expiryDate;
	private Integer cvv;
	private CardTypeBean cardType;

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
	public CardTypeBean getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
	 */
	public void setCardType(CardTypeBean cardType) {
		this.cardType = cardType;
	}

}
