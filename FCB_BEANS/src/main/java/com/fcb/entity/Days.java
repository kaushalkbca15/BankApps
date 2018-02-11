/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "days", schema = "fcbdb")
public class Days implements Serializable {
	@Id
	@GeneratedValue(generator = "dayIdGenerator")
	@GenericGenerator(name = "dayIdGenerator", strategy = "increment")
	@Column(name = "day_id")
	private Integer dayId;
	@Column(name = "day")
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
