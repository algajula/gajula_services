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
public class UserPwd_Info implements Serializable {

    @Id
    @GeneratedValue(generator = "userpwdid_seq_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "userpwdid_seq_id", sequenceName = "userpwdid_seq_id", allocationSize = 1, schema = "gajula_services")
    @Column(name = "USERPWD_UID")
    private BigInteger userpwd_uid;

    @Column(name = "USERID")
    private BigInteger userid;
    @Column(name = "FIRST_PWD")
    private String first_pwd;
    @Column(name = "SECOND_PWD")
    private String second_pwd;
    @Column(name = "THIRD_PWD")
    private String third_pwd;

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

    public BigInteger getUserpwd_uid() {
        return userpwd_uid;
    }

    public void setUserpwd_uid(BigInteger userpwd_uid) {
        this.userpwd_uid = userpwd_uid;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getFirst_pwd() {
        return first_pwd;
    }

    public void setFirst_pwd(String first_pwd) {
        this.first_pwd = first_pwd;
    }

    public String getSecond_pwd() {
        return second_pwd;
    }

    public void setSecond_pwd(String second_pwd) {
        this.second_pwd = second_pwd;
    }

    public String getThird_pwd() {
        return third_pwd;
    }

    public void setThird_pwd(String third_pwd) {
        this.third_pwd = third_pwd;
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
        return "UserPwd_Info{" +
                "userpwd_uid=" + userpwd_uid +
                ", userid=" + userid +
                ", first_pwd='" + first_pwd + '\'' +
                ", second_pwd='" + second_pwd + '\'' +
                ", third_pwd='" + third_pwd + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
