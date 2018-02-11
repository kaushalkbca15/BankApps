package com.fcb.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fcb.beans.FCBResponse;
import com.fcb.dao.UserDetailsDAO;
import com.fcb.entity.UserAuthentication;
import com.fcb.entity.UserAuthorization;
import com.fcb.util.FCBConstaint;

@Service("userService")
public class UsersDetailServiceImpl implements UserDetailsService {

	Logger logger = Logger.getLogger(UsersDetailServiceImpl.class);
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		FCBResponse fcbResponse = new FCBResponse();
		fcbResponse.setMessage("Unable to process the request please try again");
		fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
		UserAuthentication userAuthentication = null;
		if (userDetailsDAO != null && userName != null) {
			try {
				userAuthentication = userDetailsDAO.findByUserName(userName);
				List<GrantedAuthority> authorities = buildUserAuthority(userAuthentication.getUserAuthorization());
				return buildUserForAuthentication(userAuthentication, authorities);
			} catch (HibernateException e) {
				fcbResponse.setMessage("Unable to process the request please try again");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("exception occure while geting userdetails " + e);
			} catch (Exception e) {
				fcbResponse.setMessage("Unable to process the request please try again");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("exception occure while geting userdetails " + e);
			}
		}
		return null;
	}

	private List<GrantedAuthority> buildUserAuthority(UserAuthorization userAuthorizations) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userAuthorizations.getUserRole()));
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>(setAuths);

		return list;
	}

	private User buildUserForAuthentication(UserAuthentication userAuthentication, List<GrantedAuthority> authorities) {
		return new User(userAuthentication.getUsername(), userAuthentication.getPassword(),
				userAuthentication.isEnabled(), true, true, true, authorities);
	}
}
