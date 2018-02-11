package com.fcb.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="USER_AUTHORIZATION",schema = "FCBDB")
public class UserAuthorization {

    @Id
    @GenericGenerator(name ="userAuthorizationIdGenerator",strategy = "increment")
    @GeneratedValue(generator = "userAuthorizationIdGenerator")
    @Column(name = "USER_AUTHORIZATION_ID")
    private Integer userAuthorizationId;
     @OneToOne
    @JoinColumn(name = "USER_NAME",unique=true)
    private UserAuthentication userAuthentication;

    @Column(name ="USER_ROLE")
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
	public UserAuthentication getUserAuthentication() {
		return userAuthentication;
	}

	/**
	 * @param userAuthentication the userAuthentication to set
	 */
	public void setUserAuthentication(UserAuthentication userAuthentication) {
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
