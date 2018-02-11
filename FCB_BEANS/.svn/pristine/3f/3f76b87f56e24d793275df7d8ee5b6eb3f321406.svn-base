/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.fcb.entity;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 *
 * @author sathish
 * @since FCB 1.0
 */
@Entity
@Table(name="Educational_Details",schema="FCBDB")
public class EducationalDetails implements Serializable{
	@Id
	@GenericGenerator(name="educationalDetailsIdGenerator",strategy = "increment")
	@GeneratedValue(generator = "educationalDetailsIdGenerator")
	@Column(name="EDUCATIONAL_DETAILS_ID")
	private Integer educationalDetailsId;
	@Column(name = "QUALIFICATION")
	private String qualification;
	@Column(name = "INSTITUTION_NAME")
	private String institutionName;
	@Column(name = "UNIVERSITY_NAME")
	private String universityName;
	@Column(name = "PERCENTAGE")
	private  String percentage;
	@Column(name = "YEAR_OF_PASSEDOUT")
	private String yearOfPassedout;
	
	@JoinColumn(name = "EMPLOYEE_ID")
	@ManyToOne
	private Employee employee;
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
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
