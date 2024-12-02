package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER", schema = "gajula_services")
public class CustomerDto implements Serializable {

    @Id
    @GeneratedValue(generator = "custuid_seq_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "custuid_seq_id", sequenceName = "custuid_seq", allocationSize = 1, schema = "gajula_services")
    @Column(name = "CUST_UID")
    private BigInteger cust_uid;

    @Column(name = "CUSTNUMBER")
    private Long custNumber;

    @Column(name = "CUSTNAME")
    private String custName;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "PHONE", length = 10)
    private long phone;

    @Column(name = "CREATEDDATE", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private Date createdDate;

    @Column(name = "MODIFIEDDATE", columnDefinition = "TIMESTAMP", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private Date modifiedDate;

    @JsonIgnoreProperties(value = {"customer"})
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, 
	    targetEntity = VehicleDto.class)
    @JoinColumn(name = "cust_uid", referencedColumnName = "cust_uid", insertable = true, updatable = true)
    Set<VehicleDto> vehicleList = new HashSet<VehicleDto>();

    public BigInteger getCust_uid() {
	return cust_uid;
    }

    public void setCust_uid(BigInteger cust_uid) {
	this.cust_uid = cust_uid;
    }

    public Long getCustNumber() {
	return custNumber;
    }

    public void setCustNumber(Long custNumber) {
	this.custNumber = custNumber;
    }

    public String getCustName() {
	return custName;
    }

    public void setCustName(String custName) {
	this.custName = custName;
    }

    public String getEmailAddress() {
	return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }

    public long getPhone() {
	return phone;
    }

    public void setPhone(long phone) {
	this.phone = phone;
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

    public Set<VehicleDto> getVehicleList() {
	return vehicleList;
    }

    public void setVehicleList(Set<VehicleDto> vehicleList) {
	this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
	return "CustomerDto [cust_uid=" + cust_uid + ", custNumber=" + custNumber + ", custName=" + custName
		+ ", emailAddress=" + emailAddress + ", phone=" + phone + ", createdDate=" + createdDate
		+ ", modifiedDate=" + modifiedDate + ", vehicleList=" + vehicleList + "]";
    }

}
