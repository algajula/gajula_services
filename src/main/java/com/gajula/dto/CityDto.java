package com.gajula.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "CITY", schema = "gajula_services")
public class CityDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_CODE")
    private BigInteger cityCode;

    @Column(name = "CITY_NAME")
    private String cityName;

    @ManyToOne
    @JoinColumn(name="STATE_CODE")
    private StateDto state;

    public BigInteger getCityCode() {
        return cityCode;
    }

    public void setCityCode(BigInteger cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public StateDto getState() {
        return state;
    }

    public void setState(StateDto state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "cityCode=" + cityCode +
                ", cityName='" + cityName + '\'' +
                ", state=" + state +
                '}';
    }
}
