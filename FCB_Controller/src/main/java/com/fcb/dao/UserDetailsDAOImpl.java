package com.fcb.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fcb.entity.UserAuthentication;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
private static final Logger logger=Logger.getLogger(UserAuthentication.class); 
	@Autowired
	private SessionFactory factory; 
	/**
	 * This method is used for get userDetails
	 * by use name
	 * @param userName
	 * @return UserAuthentication
	 */
	public UserAuthentication findByUserName(String userName) {
		Session session=factory.openSession();
		UserAuthentication userAuthentication=null;
		if(session!=null){
			try{
				userAuthentication=(UserAuthentication) session.createCriteria(UserAuthentication.class).add(Restrictions.eq("username",userName)).uniqueResult();
			}finally {
				try{
					session.close();
				}catch (Exception e) {
					logger.error("exceprion occure while closeing session");
				}
			}
		}
		return userAuthentication;
	}
}
