package com.gajula.service;

import com.gajula.dto.CustomerDto;
import com.gajula.model.ResponseBean;

public interface CustomerService {

    public ResponseBean getCustomerDetails() throws Exception;
    public ResponseBean getvehicleDetails() throws Exception;
    public boolean saveCustomerDetails(CustomerDto customer)throws Exception;
}
