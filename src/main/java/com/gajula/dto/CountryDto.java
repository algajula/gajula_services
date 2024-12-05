package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "COUNTRY", schema = "gajula_services")
public class CountryDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_CODE")
    private BigInteger countryCode;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "REGION")
    private String region;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<StateDto> states;

    public BigInteger getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(BigInteger countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<StateDto> getStates() {
        return states;
    }

    public void setStates(List<StateDto> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "countryCode=" + countryCode +
                ", countryName='" + countryName + '\'' +
                ", region='" + region + '\'' +
                ", states=" + states +
                '}';
    }
}
