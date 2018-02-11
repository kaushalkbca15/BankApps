package com.fcb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Working_Hours", schema = "FCBDB")
public class WorkingHours implements Serializable {
	@Id
	@Column(name = "working_hour_id")
	@GeneratedValue(generator = "workingHourIdGenerator")
	@GenericGenerator(name = "workingHourIdGenerator", strategy = "increment")
	private Integer workingHourId;
	@ManyToOne
	@JoinColumn(name = "day_id")
	private Days days;
	@ManyToOne
	@JoinColumn(name = "time_id")
	private Time time;
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;

	/**
	 * @return the workingHourId
	 */
	public Integer getWorkingHourId() {
		return workingHourId;
	}

	/**
	 * @param workingHourId
	 *            the workingHourId to set
	 */
	public void setWorkingHourId(Integer workingHourId) {
		this.workingHourId = workingHourId;
	}

	/**
	 * @return the days
	 */
	public Days getDays() {
		return days;
	}

	/**
	 * @param days
	 *            the days to set
	 */
	public void setDays(Days days) {
		this.days = days;
	}

	/**
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * @return the branch
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

}
