package com.fcb.beans;

import java.io.Serializable;



public class WorkingHoursBean implements Serializable {
	private Integer workingHourId;
	private DaysBean days;
	private TimeBean time;
	private BranchBean branch;

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
	public DaysBean getDays() {
		return days;
	}

	/**
	 * @param days
	 *            the days to set
	 */
	public void setDays(DaysBean days) {
		this.days = days;
	}

	/**
	 * @return the time
	 */
	public TimeBean getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(TimeBean time) {
		this.time = time;
	}

	/**
	 * @return the branch
	 */
	public BranchBean getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(BranchBean branch) {
		this.branch = branch;
	}

}
