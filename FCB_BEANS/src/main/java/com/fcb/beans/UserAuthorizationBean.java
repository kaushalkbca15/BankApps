package com.fcb.beans;


import java.io.Serializable;


public class UserAuthorizationBean implements Serializable{

    private Integer userAuthorizationId;
    private UserAuthenticationBean userAuthentication;

    private String userRole;

	/**
	 * @return the userAuthorizationId
	 */
	public Integer getUserAuthorizationId() {
		return userAuthorizationId;
	}

	/**
	 * @param userAuthorizationId the userAuthorizationId to set
	 */
	public void setUserAuthorizationId(Integer userAuthorizationId) {
		this.userAuthorizationId = userAuthorizationId;
	}

	/**
	 * @return the userAuthentication
	 */
	public UserAuthenticationBean getUserAuthentication() {
		return userAuthentication;
	}

	/**
	 * @param userAuthentication the userAuthentication to set
	 */
	public void setUserAuthentication(UserAuthenticationBean userAuthentication) {
		this.userAuthentication = userAuthentication;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

    
}
