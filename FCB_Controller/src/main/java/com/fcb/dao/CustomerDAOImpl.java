package com.fcb.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
	@Autowired
	private SessionFactory factory;
	
	private Logger logger=Logger.getLogger(CustomerDAOImpl.class);
	
	private static final String HQL_QUERY_SELSECT_CUSTOMER_DETAILS
		="select c.email,c.mobile from Customer as c inner join c.account as a where a.accountNumber=?";
	
	/**
   	 * This method is used for getting customer mobile number and email id from customer table
	 * @param accountNumer
	 * @return Object[] 
	 */
	public Object[] getCustomerDetails(Long accountNumber) {
		Object[] objects=null;
		if(factory!=null&& accountNumber!=null){
			Session session=factory.openSession();
			if(session!=null){
				try{
					objects=(Object[])session.createQuery(HQL_QUERY_SELSECT_CUSTOMER_DETAILS)
					.setParameter(0,accountNumber)
					.uniqueResult();
				}finally{
					try{
						session.close();
					}catch(Exception e) {
						logger.error("error occure while closing sessoin :"+e);
					}//inner catch 
				}//finally
			}//if
		}//if
		return objects;
	}

}
