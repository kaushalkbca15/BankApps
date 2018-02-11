package com.fcb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Payment_System", schema = "FCBDB")
public class PaymentSystem {
	@Id
	@Column(name = "payment_system_id")
	@GeneratedValue(generator = "paymentSystemIdGenerator")
	@GenericGenerator(name = "paymentSystemIdGenerator", strategy = "increment")
	private Integer paymentSystemId;
	@Column(name = "payment_vendor")
	private String paymentVendor;

	/**
	 * @return the paymentSystemId
	 */
	public Integer getPaymentSystemId() {
		return paymentSystemId;
	}

	/**
	 * @param paymentSystemId
	 *            the paymentSystemId to set
	 */
	public void setPaymentSystemId(Integer paymentSystemId) {
		this.paymentSystemId = paymentSystemId;
	}

	/**
	 * @return the paymentVendor
	 */
	public String getPaymentVendor() {
		return paymentVendor;
	}

	/**
	 * @param paymentVendor
	 *            the paymentVendor to set
	 */
	public void setPaymentVendor(String paymentVendor) {
		this.paymentVendor = paymentVendor;
	}

}
