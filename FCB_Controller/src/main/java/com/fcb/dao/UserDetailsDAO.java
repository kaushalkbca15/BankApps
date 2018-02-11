package com.fcb.dao;

import com.fcb.entity.UserAuthentication;

public interface UserDetailsDAO {
/**
 * This method is used for get userDetails
 * @param userName
 * @return UserAuthentication
 */
	public UserAuthentication findByUserName(String userName);
}
