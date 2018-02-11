/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.fcb.beans;

import java.io.Serializable;

public class EducationalDetailsBean implements Serializable{
	private Integer educationalDetailsId;
	private String qualification;
	private String institutionName;
	private String universityName;
	private  String percentage;
	private String yearOfPassedout;
	private EmployeeBean employee;
	/**
	 * @return the educationalDetailsId
	 */
	public Integer getEducationalDetailsId() {
		return educationalDetailsId;
	}
	/**
	 * @param educationalDetailsId the educationalDetailsId to set
	 */
	public void setEducationalDetailsId(Integer educationalDetailsId) {
		this.educationalDetailsId = educationalDetailsId;
	}
	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	/**
	 * @return the institutionName
	 */
	public String getInstitutionName() {
		return institutionName;
	}
	/**
	 * @param institutionName the institutionName to set
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	/**
	 * @return the universityName
	 */
	public String getUniversityName() {
		return universityName;
	}
	/**
	 * @param universityName the universityName to set
	 */
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	/**
	 * @return the yearOfPassedout
	 */
	public String getYearOfPassedout() {
		return yearOfPassedout;
	}
	/**
	 * @param yearOfPassedout the yearOfPassedout to set
	 */
	public void setYearOfPassedout(String yearOfPassedout) {
		this.yearOfPassedout = yearOfPassedout;
	}
	/**
	 * @return the employee
	 */
	public EmployeeBean getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

}
