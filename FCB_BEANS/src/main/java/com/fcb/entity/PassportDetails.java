/*
 * Copyright (c) 2017, 2018, FCB and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * This is an entity class and used to map java class properties with database
 * table coloums
 *
 * @author sathish
 * @since FCB 1.0
 */
 @Entity
 @Table(name = "PASSPORT_DETAILS",schema = "FCBDB")
 public class PassportDetails implements Serializable {

     @Id
     @GenericGenerator(name = "passportDetailsIdGenerator",strategy = "increment")
     @GeneratedValue(generator = "passportDetailsIdGenerator")
     @Column(name ="PASSPORT_DETAILS_ID")
     private Integer passportDetailsId;

     @Column(name = "PASSPORT_NUMBER")
     private String passportNumber;

     @Column(name = "PASSPORT_ISSUED_DATE")
     private Date passportIssuedDate;

     @Column(name = "PASSPORT_EXPIRY_DATE")
     private Date passportExpiryDate;

     @Column(name = "PASSPORT_ISSUED_PLACE")
     private String issuedPlace;
    /**
     * @return the passportDetailsId
     */
    public Integer getPassportDetailsId() {
        return passportDetailsId;
    }
    /**
     * @param passportDetailsId the passportDetailsId to set
     */
    public void setPassportDetailsId(Integer passportDetailsId) {
        this.passportDetailsId = passportDetailsId;
    }
    /**
     * @return the passportNumber
     */
    public String getPassportNumber() {
        return passportNumber;
    }
    /**
     * @param passportNumber the passportNumber to set
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    /**
     * @return the passportIssuedDate
     */
    public Date getPassportIssuedDate() {
        return passportIssuedDate;
    }
    /**
     * @param passportIssuedDate the passportIssuedDate to set
     */
    public void setPassportIssuedDate(Date passportIssuedDate) {
        this.passportIssuedDate = passportIssuedDate;
    }
    /**
     * @return the passportExpiryDate
     */
    public Date getPassportExpiryDate() {
        return passportExpiryDate;
    }
    /**
     * @param passportExpiryDate the passportExpiryDate to set
     */
    public void setPassportExpiryDate(Date passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
    }
    /**
     * @return the issuedPlace
     */
    public String getIssuedPlace() {
        return issuedPlace;
    }
    /**
     * @param issuedPlace the issuedPlace to set
     */
    public void setIssuedPlace(String issuedPlace) {
        this.issuedPlace = issuedPlace;
    }

    }
