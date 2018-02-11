package com.fcb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="time",schema="FCBDB")
public class Time implements Serializable{
	@Id
	@Column(name="time_id")
	@GeneratedValue(generator="timeIdGenerator")
	@GenericGenerator(name="timeIdGenerator",
	strategy="increment")
private Integer timeId;
	@Column(name="opening_hours")
private String openingHours;
	@Column(name="closing_hours")
private String closingHours;
/**
 * @return the timeId
 */
public Integer getTimeId() {
	return timeId;
}
/**
 * @param timeId the timeId to set
 */
public void setTimeId(Integer timeId) {
	this.timeId = timeId;
}
/**
 * @return the openingHours
 */
public String getOpeningHours() {
	return openingHours;
}
/**
 * @param openingHours the openingHours to set
 */
public void setOpeningHours(String openingHours) {
	this.openingHours = openingHours;
}
/**
 * @return the closingHours
 */
public String getClosingHours() {
	return closingHours;
}
/**
 * @param closingHours the closingHours to set
 */
public void setClosingHours(String closingHours) {
	this.closingHours = closingHours;
}

}
