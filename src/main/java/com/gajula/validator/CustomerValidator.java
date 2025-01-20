package com.gajula.validator;

import com.gajula.dto.CustomerDto;
import com.gajula.model.ResponseBean;
import com.gajula.util.APIConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class CustomerValidator {

    private final static Logger admin = LogManager.getLogger(CustomerValidator.class);

    public ResponseBean validateForm(CustomerDto customer){
        ResponseBean response=new ResponseBean();
        HashMap<String, String> labels = new HashMap<>();
        try{
            if(!NumberUtils.isDigits(String.valueOf(customer.getCustNumber()))){
                labels.put("custNumberErr","CustNumber should be numeric!");
            }
            if(StringUtils.isEmpty(customer.getCustName())){
                labels.put("custNameErr","CustName should not be emptye!");
            }
            if(StringUtils.isEmpty(customer.getEmailAddress())){
                labels.put("emailAddressErr","EmailAddress should not be emptye!");
            }
            admin.info("labels  map "+labels);
            response.setResult(labels);
            response.setStatusCode(APIConstants.DATA_VALIDATION_CODE);
            response.setStatusDescription(APIConstants.DATA_VALIDATION_DESC);
        }catch (Exception e){
            admin.error("error in CustomerValidator "+e.getMessage());
            response.setResult("");
            response.setStatusCode(APIConstants.DATA_VALIDATION_CODE);
            response.setStatusDescription(APIConstants.DATA_VALIDATION_DESC);
        }
        return response;
    }
}
