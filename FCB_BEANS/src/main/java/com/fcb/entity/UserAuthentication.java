/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 *
 * @author sathish
 * @since FCB 1.0
 */
@Entity
@Table(name = "USER_AUTHENTICATION", schema = "FCBDB")
public class UserAuthentication {

	/*
	 * @Id
	 * 
	 * @Column(name="USER_AUTHENTICATION_ID")
	 * 
	 * @GenericGenerator(name = "userAuthenticationIdGenerator", strategy =
	 * "increment")
	 * 
	 * @GeneratedValue(generator= "userAuthenticationIdGenerator") private
	 * Integer userAuthenticationId;
	 */
	@Column(name = "USER_NAME")
	@Id
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "SECURITY_CODE")
	private String securityCode;
	@Column(name = "enabled")
	private boolean enabled;
	
	
	@OneToOne(mappedBy = "userAuthentication")
	private UserAuthorization userAuthorization;
	
	@OneToOne
	@JoinColumn(name = "employee_id", unique = true)
	private Employee employee;

	public UserAuthorization getUserAuthorization() {
		return userAuthorization;
	}

	public void setUserAuthorization(UserAuthorization userAuthorization) {
		this.userAuthorization = userAuthorization;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the userAuthenticationId
	 */
	/*
	 * public Integer getUserAuthenticationId() { return userAuthenticationId; }
	 * 
	 *//**
		 * @param userAuthenticationId
		 *            the userAuthenticationId to set
		 *//*
		 * public void setUserAuthenticationId(Integer userAuthenticationId) {
		 * this.userAuthenticationId = userAuthenticationId; }
		 */

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the securityCode
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * @param securityCode
	 *            the securityCode to set
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

}
