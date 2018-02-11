package com.fcb.beans;

import java.io.Serializable;
import java.util.Date;


public class CustomerBean implements Serializable {
	
	
	private Integer customerId;
	
	private String firstName;
	private String lastName;
	private String fatherName;
	private String gender;
	private String email;
	private String dob;
	private String mobile;
	private PresentAddressBean presentAddress;
	private PermanentAddressBean permanentAddress;
	private IdentificationProofBean identificationProof;
	private AddressProofBean addressProof;
	private OtherIdCardBean otherIdCard;
	private byte[] customerSign;
	private byte[] customerPhoto;
	private NomineeBean nominee;
	private AccountBean account;
	
	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName
	 *            the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dob


	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	

	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the account
	 */
	public AccountBean getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(AccountBean account) {
		this.account = account;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the presentAddress
	 */
	public PresentAddressBean getPresentAddress() {
		return presentAddress;
	}

	/**
	 * @param presentAddress
	 *            the presentAddress to set
	 */
	public void setPresentAddress(PresentAddressBean presentAddress) {
		this.presentAddress = presentAddress;
	}

	/**
	 * @return the permanentAddress
	 */
	public PermanentAddressBean getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @param permanentAddress
	 *            the permanentAddress to set
	 */
	public void setPermanentAddress(PermanentAddressBean permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	/**
	 * @return the identificationProof
	 */
	public IdentificationProofBean getIdentificationProof() {
		return identificationProof;
	}

	/**
	 * @param identificationProof
	 *            the identificationProof to set
	 */
	public void setIdentificationProof(IdentificationProofBean identificationProof) {
		this.identificationProof = identificationProof;
	}

	/**
	 * @return the addressProof
	 */
	public AddressProofBean getAddressProof() {
		return addressProof;
	}

	/**
	 * @param addressProof
	 *            the addressProof to set
	 */
	public void setAddressProof(AddressProofBean addressProof) {
		this.addressProof = addressProof;
	}

	/**
	 * @return the otherIdCard
	 */
	public OtherIdCardBean getOtherIdCard() {
		return otherIdCard;
	}

	/**
	 * @param otherIdCard
	 *            the otherIdCard to set
	 */
	public void setOtherIdCard(OtherIdCardBean otherIdCard) {
		this.otherIdCard = otherIdCard;
	}

	/**
	 * @return the customerSign
	 */
	public byte[] getCustomerSign() {
		return customerSign;
	}

	/**
	 * @param customerSign
	 *            the customerSign to set
	 */
	public void setCustomerSign(byte[] customerSign) {
		this.customerSign = customerSign;
	}

	/**
	 * @return the customerPhoto
	 */
	public byte[] getCustomerPhoto() {
		return customerPhoto;
	}

	/**
	 * @param customerPhoto
	 *            the customerPhoto to set
	 */
	public void setCustomerPhoto(byte[] customerPhoto) {
		this.customerPhoto = customerPhoto;
	}

	/**
	 * @return the nominee
	 */
	public NomineeBean getNominee() {
		return nominee;
	}

	/**
	 * @param nominee
	 *            the nominee to set
	 */
	public void setNominee(NomineeBean nominee) {
		this.nominee = nominee;
	}

}
