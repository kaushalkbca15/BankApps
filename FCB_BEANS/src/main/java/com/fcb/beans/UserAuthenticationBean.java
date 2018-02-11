/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.beans;

import java.io.Serializable;

public class UserAuthenticationBean implements Serializable {

	private String username;
	private String password;
	private String securityCode;
	private boolean enabled;
	private UserAuthorizationBean userAuthorization;
	private EmployeeBean employee;

	public UserAuthorizationBean getUserAuthorization() {
		return userAuthorization;
	}

	public void setUserAuthorization(UserAuthorizationBean userAuthorization) {
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
