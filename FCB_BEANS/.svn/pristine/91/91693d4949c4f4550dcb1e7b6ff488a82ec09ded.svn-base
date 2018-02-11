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
@Table(name = "Loan", schema = "FCBDB")
public class Loan {
	@Id
	@Column(name = "Loan_Id")
	@GeneratedValue(generator = "loanIdGenerator")
	@GenericGenerator(name = "loanIdGenerator", strategy = "increment")
	private Integer loanId;
	@ManyToOne
	@JoinColumn(name = "customer_Id")
	private Customer customer;
	@Column(name = "loan_amount")
	private Integer loanAmount;
	@Column(name = "loan_borrow_date")
	private Date loanBorrowDate;
	@Column(name = "loan_due_date")
	private Date loanDueDate;
	@Column(name = "monthly_installment")
	private Integer monthlyInstallment;
	@Column(name = "status")
	private String status;
	@ManyToOne
	@JoinColumn(name = "loan_type_id")
	private LoanType loanType;

	/**
	 * @return the loanId
	 */
	public Integer getLoanId() {
		return loanId;
	}

	/**
	 * @param loanId
	 *            the loanId to set
	 */
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the loanAmount
	 */
	public Integer getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount
	 *            the loanAmount to set
	 */
	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the loanBorrowDate
	 */
	public Date getLoanBorrowDate() {
		return loanBorrowDate;
	}

	/**
	 * @param loanBorrowDate
	 *            the loanBorrowDate to set
	 */
	public void setLoanBorrowDate(Date loanBorrowDate) {
		this.loanBorrowDate = loanBorrowDate;
	}

	/**
	 * @return the loanDueDate
	 */
	public Date getLoanDueDate() {
		return loanDueDate;
	}

	/**
	 * @param loanDueDate
	 *            the loanDueDate to set
	 */
	public void setLoanDueDate(Date loanDueDate) {
		this.loanDueDate = loanDueDate;
	}

	/**
	 * @return the monthlyInstallment
	 */
	public Integer getMonthlyInstallment() {
		return monthlyInstallment;
	}

	/**
	 * @param monthlyInstallment
	 *            the monthlyInstallment to set
	 */
	public void setMonthlyInstallment(Integer monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the loanType
	 */
	public LoanType getLoanType() {
		return loanType;
	}

	/**
	 * @param loanType
	 *            the loanType to set
	 */
	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

}
