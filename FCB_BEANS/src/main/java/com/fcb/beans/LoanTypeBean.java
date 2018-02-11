package com.fcb.beans;

import java.io.Serializable;

public class LoanTypeBean implements Serializable{
	private Integer loanTypeId;
	private String loanTypeName;
	private Integer interestRate;

	/**
	 * @return the loanTypeId
	 */
	public Integer getLoanTypeId() {
		return loanTypeId;
	}

	/**
	 * @param loanTypeId
	 *            the loanTypeId to set
	 */
	public void setLoanTypeId(Integer loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	/**
	 * @return the loanTypeName
	 */
	public String getLoanTypeName() {
		return loanTypeName;
	}

	/**
	 * @param loanTypeName
	 *            the loanTypeName to set
	 */
	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}

	/**
	 * @return the interestRate
	 */
	public Integer getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate
	 *            the interestRate to set
	 */
	public void setInterestRate(Integer interestRate) {
		this.interestRate = interestRate;
	}

}
