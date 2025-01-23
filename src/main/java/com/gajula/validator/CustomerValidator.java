package com.gajula.validator;

import com.gajula.model.CustomerBean;
import com.gajula.util.DateUtilHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomerValidator {

    private final static Logger admin = LogManager.getLogger(CustomerValidator.class);
    public final static Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Autowired
    private MessageSource messageSource;

    public HashMap<String, String> validateForm(CustomerBean customer){
        HashMap<String, String> labels = new HashMap<>();
        try{
            if(null  == customer.getCustNumber()){
                labels.put("custNumberErr",messageSource.getMessage("error.cusNumber01", null, new Locale("us")));
            }else if(!NumberUtils.isDigits(String.valueOf(customer.getCustNumber()))){
                labels.put("custNumberErr",messageSource.getMessage("error.cusNumber02", null, new Locale("us")));
            }
            if(StringUtils.isEmpty(customer.getCustName())){
                labels.put("custNameErr",messageSource.getMessage("error.cusName01", null, new Locale("us")));
            }else if(customer.getCustName().length() < 5 || customer.getCustName().length() >= 25 ){
                labels.put("custNameErr",messageSource.getMessage("error.cusName02", null, new Locale("us")));
            }
            if(StringUtils.isEmpty(customer.getEmailAddress())){
                labels.put("emailAddressErr",messageSource.getMessage("error.emailAddress01", null, new Locale("us")));
            }else if(!validateEmail(customer.getEmailAddress())){
                labels.put("emailAddressErr",messageSource.getMessage("error.emailAddress02", null, new Locale("us")));
            }

            if(null  == customer.getPhone()){
                labels.put("phoneErr",messageSource.getMessage("error.phone01", null, new Locale("us")));
            }else if(!NumberUtils.isDigits(String.valueOf(customer.getPhone()))){
                labels.put("phoneErr",messageSource.getMessage("error.phone02", null, new Locale("us")));
            }else if(String.valueOf(customer.getPhone()).length() != 10){
                labels.put("phoneErr",messageSource.getMessage("error.phone03", null, new Locale("us")));
            }

            //pending date validations
            admin.info("Date selected==========="+customer.getCreatedDate());
            if(StringUtils.isEmpty(customer.getCreatedDate())){
                labels.put("createdDateErr",messageSource.getMessage("error.createdDate01", null, new Locale("us")));
            }else if(!DateUtilHelper.isTodaysDate(customer.getCreatedDate())){
                labels.put("createdDateErr",messageSource.getMessage("error.createdDate02", null, new Locale("us")));
            }
            admin.info("labels  map "+labels);
        }catch (Exception e){
            e.printStackTrace();
            admin.error("error in CustomerValidator "+e.getMessage());
        }
        return labels;
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
}
