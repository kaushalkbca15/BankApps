package com.fcb.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

public class AccountServicesBean implements Serializable{
	private Integer accountActiveServiceId;
	private String serviceName;
	private List<AccountBean> accountsList;

	/**
	 * @return the accountsList
	 */
	public List<AccountBean> getAccountsList() {
		return accountsList;
	}

	/**
	 * @param accountsList
	 *            the accountsList to set
	 */
	public void setAccountsList(List<AccountBean> accountsList) {
		this.accountsList = accountsList;
	}

	/**
	 * @return the accountActiveServiceId
	 */
	public Integer getAccountActiveServiceId() {
		return accountActiveServiceId;
	}

	/**
	 * @param accountActiveServiceId
	 *            the accountActiveServiceId to set
	 */
	public void setAccountActiveServiceId(Integer accountActiveServiceId) {
		this.accountActiveServiceId = accountActiveServiceId;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
