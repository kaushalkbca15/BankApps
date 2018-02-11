package com.fcb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "nominee", schema = "FCBDB")
public class Nominee implements Serializable {
	@Id
	@Column(name = "nominee_id")
	@GeneratedValue(generator = "nomineeIdGenerator")
	@GenericGenerator(name = "nomineeIdGenerator", strategy = "increment")
	private Integer nomineeId;
	@Column(name = "name")
	private String name;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "relation")
	private String relation;

	/**
	 * @return the nomineeId
	 */
	public Integer getNomineeId() {
		return nomineeId;
	}

	/**
	 * @param nomineeId
	 *            the nomineeId to set
	 */
	public void setNomineeId(Integer nomineeId) {
		this.nomineeId = nomineeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dob
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
	 * @return the relation
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * @param relation
	 *            the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

}
