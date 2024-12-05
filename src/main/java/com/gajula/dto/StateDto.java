package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "STATE", schema = "gajula_services")
public class StateDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATE_CODE")
    private BigInteger stateCode;

    @Column(name = "STATE_NAME")
    private String stateName;

    @ManyToOne
    @JoinColumn(name="COUNTRY_CODE")
    private CountryDto country;

    @OneToMany(mappedBy = "state")
    @JsonIgnore
    private List<CityDto> cities;

    public BigInteger getStateCode() {
        return stateCode;
    }

    public void setStateCode(BigInteger stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "StateDto{" +
                "stateCode=" + stateCode +
                ", stateName='" + stateName + '\'' +
                ", country=" + country +
                ", cities=" + cities +
                '}';
    }
}
