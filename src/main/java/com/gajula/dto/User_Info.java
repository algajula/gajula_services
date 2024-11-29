package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "USER_INFO", schema = "book_services")
public class User_Info implements Serializable {

    @Id
    @GeneratedValue(generator = "userid_seq_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "userid_seq_id", sequenceName = "userid_seq", allocationSize = 1, schema = "book_services")
    @Column(name = "USER_UID")
    private BigInteger user_uid;

    @Column(name = "USERID")
    private BigInteger userid;
    @Column(name = "FULL_NAME")
    private String FULL_name;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Column(name = "DATE_OF_BIRTH", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfBirth;

    @Column(name = "PHONE", length = 10)
    private String phone;
    @Column(name = "ALTERNATE_PHONE", length = 10)
    private String alternatePhone;
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @CreatedDate
    private Date createdDate;

    @Column(name = "MODIFIED_DATE", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @LastModifiedDate
    private Date modifiedDate;

    public BigInteger getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(BigInteger user_uid) {
        this.user_uid = user_uid;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getFULL_name() {
        return FULL_name;
    }

    public void setFULL_name(String FULL_name) {
        this.FULL_name = FULL_name;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "User_Info{" +
                "user_uid=" + user_uid +
                ", userid=" + userid +
                ", FULL_name='" + FULL_name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                ", alternatePhone='" + alternatePhone + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
