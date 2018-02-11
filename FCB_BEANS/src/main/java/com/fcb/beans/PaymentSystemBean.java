package com.fcb.beans;

import java.io.Serializable;

public class PaymentSystemBean implements Serializable{
	private Integer paymentSystemId;
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
