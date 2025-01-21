package com.gajula.validator;

import com.gajula.model.CustomerBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomerValidator {

    private final static Logger admin = LogManager.getLogger(CustomerValidator.class);
    public final static Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public HashMap<String, String> validateForm(CustomerBean customer){
        HashMap<String, String> labels = new HashMap<>();
        try{
            if(null  == customer.getCustNumber()){
                labels.put("custNumberErr","CustNumber should not be empty!");
            }else if(!NumberUtils.isDigits(String.valueOf(customer.getCustNumber()))){
                labels.put("custNumberErr","CustNumber should be numeric!");
            }
            if(StringUtils.isEmpty(customer.getCustName())){
                labels.put("custNameErr","CustName should not be empty!");
            }else if(customer.getCustName().length() < 5 || customer.getCustName().length() >= 25 ){
                labels.put("custNameErr","CustName Name should minimum 5chars and maximum 25!");
            }
            if(StringUtils.isEmpty(customer.getEmailAddress())){
                labels.put("emailAddressErr","EmailAddress should not be empty!");
            }else if(!validateEmail(customer.getEmailAddress())){
                labels.put("emailAddressErr","EmailAddress pattern should not match!");
            }

            if(null  == customer.getPhone()){
                labels.put("phoneErr","Mobile Number should not be empty!");
            }else if(!NumberUtils.isDigits(String.valueOf(customer.getPhone()))){
                labels.put("phoneErr","Mobile Number should be numeric!");
            }else if(String.valueOf(customer.getPhone()).length() != 10){
                labels.put("phoneErr","Mobile Number should be 10digitd!");
            }

            //pending date validations
            admin.info("Date selected==========="+customer.getCreatedDate());
            if(StringUtils.isEmpty(customer.getCreatedDate())){
                labels.put("createdDateErr","Please select date!");
            }
            admin.info("labels  map "+labels);
        }catch (Exception e){
            admin.error("error in CustomerValidator "+e.getMessage());
        }
        return labels;
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
}
