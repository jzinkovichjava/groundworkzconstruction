package com.zinkovich.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by jrzinkovich on 2/7/16.
 */
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="address1")
    private String address1;

    @Column(name="address2")
    private String address2;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="zip")
    private String zip;

    @Column(name="email")
    private String emailAddress;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="existing")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean existing;

    @Column(name="prospective")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean prospective = Boolean.TRUE;

    @Column(name="comments")
    private String comments;

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

    public String getZip() {
        return zip;
    }

    public void setZip(String zipCode) {
        this.zip = zipCode;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("New Customer Stored");
        sb.append("Customer Name:").append(this.firstName).append(" ").append(this.lastName);
        sb.append(System.getProperty("line.separator"));
        sb.append("Customer Address:").append(this.address1).append(" ").append(this.city).append(" ").append(this.state).append(" ").append(this.zip);
        sb.append(System.getProperty("line.separator"));
        sb.append("Customer Email:").append(" ").append(this.emailAddress).append(" ").append("Phone: ").append(" ").append(this.phoneNumber);
        sb.append(System.getProperty("line.separator"));
        sb.append("Comments: ").append(this.comments);
        return sb.toString();
    }
}
