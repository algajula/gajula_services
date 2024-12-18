package com.gajula.model;

import java.io.Serializable;
import java.util.HashMap;

public class ValidateForm implements Serializable {

    private boolean hasRrrors;
    private HashMap<String, String> errorlabels;

    public boolean isHasRrrors() {
        return hasRrrors;
    }

    public void setHasRrrors(boolean hasRrrors) {
        this.hasRrrors = hasRrrors;
    }

    public HashMap<String, String> getErrorlabels() {
        return errorlabels;
    }

    public void setErrorlabels(HashMap<String, String> errorlabels) {
        this.errorlabels = errorlabels;
    }

    @Override
    public String toString() {
        return "ValidateForm{" +
                "hasRrrors=" + hasRrrors +
                ", errorlabels=" + errorlabels +
                '}';
    }
}
