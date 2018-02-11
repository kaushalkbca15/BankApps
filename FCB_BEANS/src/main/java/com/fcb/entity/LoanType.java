package com.fcb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Loan_Type", schema = "FCBDB")
public class LoanType {
	@Id
	@Column(name = "Loan_Type_Id")
	@GeneratedValue(generator = "loanTypeIdGenerator")
	@GenericGenerator(name = "loanTypeIdGenerator", strategy = "increment")
	private Integer loanTypeId;
	@Column(name = "Loan_Type_Name")
	private String loanTypeName;
	@Column(name = "Interest_Rate")
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
