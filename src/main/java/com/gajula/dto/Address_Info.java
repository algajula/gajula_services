package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "ADDRESS_INFO", schema = "book_services")
public class Address_Info implements Serializable {

    @Id
    @GeneratedValue(generator = "addruid_seq_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "addruid_seq_id", sequenceName = "addruid_seq_id", allocationSize = 1, schema = "book_services")
    @Column(name = "ADDR_UID")
    private BigInteger addr_uid;

    @Column(name = "USERID")
    private BigInteger userid;

    @Column(name = "FLAT")
    private String flat;
    @Column(name = "STREET")
    private String street;
    @Column(name = "AREA")
    private String area;
    @Column(name = "landmark")
    private String landmark;

    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "STATE")
    private String state;
    @Column(name = "CITY")
    private String city;
    @Column(name = "TOWN")
    private String town;
    @Column(name = "ZIPCODE")
    private String zipcode;

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

    public BigInteger getAddr_uid() {
        return addr_uid;
    }

    public void setAddr_uid(BigInteger addr_uid) {
        this.addr_uid = addr_uid;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
        return "Address_Info{" +
                "addr_uid=" + addr_uid +
                ", userid=" + userid +
                ", flat='" + flat + '\'' +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", landmark='" + landmark + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
