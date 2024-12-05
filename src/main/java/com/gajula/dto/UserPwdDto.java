package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "USERPWD_INFO", schema = "gajula_services")
public class UserPwdDto implements Serializable {

    @Id
    @GeneratedValue(generator = "userpwdid_seq_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "userpwdid_seq_id", sequenceName = "userpwdid_seq_id", allocationSize = 1, schema = "gajula_services")
    @Column(name = "USERPWD_UID")
    private BigInteger userpwdUid;

    @Column(name = "USERID")
    private BigInteger userId;
    @Column(name = "FIRST_PWD")
    private String firstPwd;
    @Column(name = "SECOND_PWD")
    private String secondPwd;
    @Column(name = "THIRD_PWD")
    private String thirdPwd;

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

    public BigInteger getUserpwdUid() {
        return userpwdUid;
    }

    public void setUserpwdUid(BigInteger userpwdUid) {
        this.userpwdUid = userpwdUid;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getFirstPwd() {
        return firstPwd;
    }

    public void setFirstPwd(String firstPwd) {
        this.firstPwd = firstPwd;
    }

    public String getSecondPwd() {
        return secondPwd;
    }

    public void setSecondPwd(String secondPwd) {
        this.secondPwd = secondPwd;
    }

    public String getThirdPwd() {
        return thirdPwd;
    }

    public void setThirdPwd(String thirdPwd) {
        this.thirdPwd = thirdPwd;
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
        return "UserPwdDto{" +
                "userpwdUid=" + userpwdUid +
                ", userId=" + userId +
                ", firstPwd='" + firstPwd + '\'' +
                ", secondPwd='" + secondPwd + '\'' +
                ", thirdPwd='" + thirdPwd + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
