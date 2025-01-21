package com.gajula.model;


import java.io.Serializable;
import java.math.BigInteger;

public class VehicleBean implements Serializable {

    private BigInteger veh_uid;
    private String vin;
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
}
