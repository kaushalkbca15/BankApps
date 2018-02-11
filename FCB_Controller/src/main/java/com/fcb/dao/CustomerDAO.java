package com.fcb.dao;

/**
 * 
 * @author kaushal
 *
 */
public interface CustomerDAO {
	/**
	 * This method is used for getting customer mobile number and email details
	 * @param AccountDetails
	 * @return Object[]
	 */
	public Object[] getCustomerDetails(Long AccountDetails);
}
