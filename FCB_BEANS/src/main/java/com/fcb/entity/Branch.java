/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 * 
 * @author sathish
 * @since FCB 1.0
 */
@Entity
@Table(name = "branch", schema = "FCBDB")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Branch implements Serializable {

	

	@Id
	@Column(name = "branch_id")
	@GeneratedValue(generator = "branchIdGenerator")
	@GenericGenerator(name = "branchIdGenerator", strategy = "increment")
	private Integer branchId;
	@Column(name = "branch_name")
	private String branchName;
	@Column(name = "branch_address")
	private String address;
	@Column(name = "branch_city")
	private String city;
	@Column(name = "branch_state")
	private String state;
	@Column(name = "branch_country")
	private String country;
	@Column(name = "branch_zipcode")
	private String zipcode;
	@Column(name = "branch_email")
	private String email;
	@Column(name = "branch_phone_number1")
	private String phoneNumber1;
	@Column(name = "branch_phone_number2")
	private String phoneNumber2;
	@Column(name = "bank_identifier_code")
	private String bankIdentifierCode;
	@Column(name = "branch_code")
	private String branchCode;
	
	@Column(name = "cheque_processing_code")
	private String chequeeProcessingCode;
	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bank;
	
	@OneToMany(targetEntity=Employee.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="BRANCH_ID",referencedColumnName="branch_id")
	private Set<Employee> employee;

	/**
	 * @return the employee
	 */
	public Set<Employee> getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId
	 *            the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName
	 *            the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode
	 *            the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber1
	 */
	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	/**
	 * @param phoneNumber1
	 *            the phoneNumber1 to set
	 */
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	/**
	 * @return the phoneNumber2
	 */
	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	/**
	 * @param phoneNumber2
	 *            the phoneNumber2 to set
	 */
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	/**
	 * @return the bankIdentifierCode
	 */
	public String getBankIdentifierCode() {
		return bankIdentifierCode;
	}

	/**
	 * @param bankIdentifierCode
	 *            the bankIdentifierCode to set
	 */
	public void setBankIdentifierCode(String bankIdentifierCode) {
		this.bankIdentifierCode = bankIdentifierCode;
	}

	/**
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode
	 *            the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the chequeeProcessingCode
	 */
	public String getChequeeProcessingCode() {
		return chequeeProcessingCode;
	}

	/**
	 * @param chequeeProcessingCode
	 *            the chequeeProcessingCode to set
	 */
	public void setChequeeProcessingCode(String chequeeProcessingCode) {
		this.chequeeProcessingCode = chequeeProcessingCode;
	}

	/**
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * @param bank
	 *            the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
