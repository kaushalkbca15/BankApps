/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 *
 * @author sathish
 * @since FCB 1.0
 */
@Entity
@Table(name = "Employee", schema = "FCBDB")
public class Employee {
	@Id
	@GenericGenerator(name = "employeeIdGenerator", strategy = "increment")
	@GeneratedValue(generator = "employeeIdGenerator")
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "MOBILE")
	private String mobile;
	@Column(name = "BLOOD_GROUP")
	private String bloodGroup;
	@Column(name = "DESIGNATION")
	private String desgination;
	@Column(name = "SALARY")
	private String salary;
	@Column(name = "STATUS")
	private Integer status;
	@Column(name = "CREATED_BY")
	private Integer createdBy;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "JOINING_DATE")
	private Date joiningDate;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "PERMANENT_ADDRESS_ID", unique = true)
	private PermanentAddress permanentAddress;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "PRESENT_ADDRESS_ID", unique = true)
	private PresentAddress presentAddress;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "IDENTIFICATION_PROOF_ID", unique = true)
	private IdentificationProof identificationProof;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_PROOF_ID", unique = true)
	private AddressProof addressProof;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "PASSPORT_ID", unique = true)
	private PassportDetails passport;

	
	@ManyToOne(targetEntity=Branch.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "BRANCH_ID",referencedColumnName="branch_id")
	private Branch branch;

	@OneToOne(mappedBy = "employee",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private UserAuthentication userAuthentication;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "OTHER_CARD_ID", unique = true)
	private OtherIdCard otherCard;

	/**
	 * @return the employeeId;
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the firstName;
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the identificationProof;
	 */
	public IdentificationProof getIdentificationProof() {
		return identificationProof;
	}

	/**
	 * @param identificationProof
	 *            the identificationProof to set
	 */
	public void setIdentificationProof(IdentificationProof identificationProof) {
		this.identificationProof = identificationProof;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName;
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dob;
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender;
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the email;
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
	 * @return the mobile;
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the bloodGroup;
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * @param bloodGroup
	 *            the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * @return the permanentAddress;
	 */
	public PermanentAddress getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @param permanentAddress
	 *            the permanentAddress to set
	 */
	public void setPermanentAddress(PermanentAddress permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	/**
	 * @return the presentAddress;
	 */
	public PresentAddress getPresentAddress() {
		return presentAddress;
	}

	/**
	 * @param presentAddress
	 *            the presentAddress to set
	 */
	public void setPresentAddress(PresentAddress presentAddress) {
		this.presentAddress = presentAddress;
	}

	/**
	 * @return the addressProof;
	 */
	public AddressProof getAddressProof() {
		return addressProof;
	}

	/**
	 * @param addressProof
	 *            the addressProof to set
	 */
	public void setAddressProof(AddressProof addressProof) {
		this.addressProof = addressProof;
	}

	/**
	 * @return the passport;
	 */
	public PassportDetails getPassport() {
		return passport;
	}

	/**
	 * @param passport
	 *            the passport to set
	 */
	public void setPassport(PassportDetails passport) {
		this.passport = passport;
	}

	/**
	 * @return the joiningDate;
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate
	 *            the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 * @return the desgination;
	 */
	public String getDesgination() {
		return desgination;
	}

	/**
	 * @param desgination
	 *            the desgination to set
	 */
	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	/**
	 * @return the salary;
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * @return the branch;
	 */
	public Branch getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	/**
	 * @return the status;
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the createdBy;
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate;
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the userAuthentication;
	 */
	public UserAuthentication getUserAuthentication() {
		return userAuthentication;
	}

	/**
	 * @param userAuthentication
	 *            the userAuthentication to set
	 */
	public void setUserAuthentication(UserAuthentication userAuthentication) {
		this.userAuthentication = userAuthentication;
	}

	/**
	 * @return the otherCard;
	 */
	public OtherIdCard getOtherCard() {
		return otherCard;
	}

	/**
	 * @param otherCard
	 *            the otherCard to set
	 */
	public void setOtherCard(OtherIdCard otherCard) {
		this.otherCard = otherCard;
	}
}
