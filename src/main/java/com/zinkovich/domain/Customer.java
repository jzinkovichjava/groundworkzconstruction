package com.zinkovich.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by jrzinkovich on 2/7/16.
 */
@Entity
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="ADDRESS1")
    private String address1;
    @Column(name="ADDRESS2")
    private String address2;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE")
    private String state;
    @Column(name="ZIPCODE")
    private String zipCode;
    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    @Column(name="EXISTING")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean existing;

    @Column(name="PROSPECTIVE")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean prospective;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public boolean isProspective() {
        return prospective;
    }

    public void setProspective(boolean prospective) {
        this.prospective = prospective;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
