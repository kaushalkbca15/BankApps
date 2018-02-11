package com.fcb.beans;

import java.io.Serializable;

public class AccountStatus implements Serializable {
	/**
	 * satish mk
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long accountNumber;
	private Integer accountStatus;
	private String accountHolderName;
	private String branchName;

	public int hashcode() {
		return accountNumber.hashCode();
	}

	public boolean equals(Object obj) {
		boolean flag = false;
		if (obj instanceof AccountStatus) {
			AccountStatus accountStatus = (AccountStatus) obj;
			if (this.accountNumber.equals(accountStatus.getAccountNumber())
					&& this.accountHolderName.equals(accountStatus.getAccountHolderName())
					&& this.accountStatus.equals(accountStatus.getAccountStatus())
					&& this.branchName.equals(accountStatus.getBranchName())) {
				flag = true;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * @return the accountNumber
	 */
	public Long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountStatus
	 */
	public Integer getAccountStatus() {
		return accountStatus;
	}

	/**
	 * @param accountStatus
	 *            the accountStatus to set
	 */
	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	/**
	 * @return the accountHolderName
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}

	/**
	 * @param accountHolderName
	 *            the accountHolderName to set
	 */
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName
	 *            the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public String toString() {
		return "AccountStatus [accountNumber=" + accountNumber + ", accountStatus=" + accountStatus
				+ ", accountHolderName=" + accountHolderName + ", branchName=" + branchName + "]";
	}

}
