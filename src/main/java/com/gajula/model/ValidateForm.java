package com.gajula.model;

import java.io.Serializable;
import java.util.HashMap;

public class ValidateForm implements Serializable {

    private boolean hasErrors;
    private HashMap<String, String> errorlabels;

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
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
                "hasErrors=" + hasErrors +
                ", errorlabels=" + errorlabels +
                '}';
    }
}
