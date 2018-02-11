package com.fcb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Account_Services", schema = "FCBDB")
public class AccountServices {
	@Id
	@Column(name = "account_active_service_id")
	@GenericGenerator(strategy = "increment", name = "accountActiveServiceIdGenerator")
	@GeneratedValue(generator = "accountActiveServiceIdGenerator")
	private Integer accountActiveServiceId;
	@Column(name = "Service_Name")
	private String serviceName;
	@ManyToMany(mappedBy = "accountServicesList")
	private List<Account> accountsList;

	/**
	 * @return the accountsList
	 */
	public List<Account> getAccountsList() {
		return accountsList;
	}

	/**
	 * @param accountsList
	 *            the accountsList to set
	 */
	public void setAccountsList(List<Account> accountsList) {
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
