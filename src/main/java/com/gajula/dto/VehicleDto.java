package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "VEHICLE", schema = "gajula_services")
public class VehicleDto {

    @Id
    @GeneratedValue(generator = "vehuid_seq_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vehuid_seq_id", sequenceName = "vehuid_seq", allocationSize = 1, schema = "gajula_services")
    @Column(name = "VEHICLE_UID")
    private BigInteger veh_uid;

    @Column(name = "VIN")
    private String vin;
    @Column(name = "VRN")
    private String vrn;

    public BigInteger getVeh_uid() {
        return veh_uid;
    }

    public void setVeh_uid(BigInteger veh_uid) {
        this.veh_uid = veh_uid;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVrn() {
        return vrn;
    }

    public void setVrn(String vrn) {
        this.vrn = vrn;
    }

    /*@Column(name = "CUST_UID", insertable = false, updatable = false)
    private BigInteger cust_uid;
    
    public BigInteger getCust_uid() {
        return cust_uid;
    }
    
    public void setCust_uid(BigInteger cust_uid) {
        this.cust_uid = cust_uid;
    }*/

    @JsonIgnoreProperties(value = {"vehicleList"})
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerDto.class)
    @JoinColumn(name = "cust_uid", referencedColumnName = "cust_uid")
    private CustomerDto customer;
    
    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }    
    
    
}
