/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

public class DaysBean implements Serializable {
	private Integer dayId;
	private String day;

	/**
	 * @return the dayId
	 */
	public Integer getDayId() {
		return dayId;
	}

	/**
	 * @param dayId
	 *            the dayId to set
	 */
	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Days [dayId=" + dayId + ", day=" + day + "]";
	}

}
