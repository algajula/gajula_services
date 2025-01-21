package com.gajula.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class CustomerBean implements Serializable {

    private BigInteger cust_uid;
    private String custNumber;
    private String custName;
    private String emailAddress;
    private String phone;
    private String createdDate;
    private String modifiedDate;
    Set<VehicleBean> vehicleList= new HashSet<VehicleBean>();;

    public BigInteger getCust_uid() {
        return cust_uid;
    }

    public void setCust_uid(BigInteger cust_uid) {
        this.cust_uid = cust_uid;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Set<VehicleBean> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(Set<VehicleBean> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
