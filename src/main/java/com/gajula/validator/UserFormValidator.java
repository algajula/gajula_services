package com.gajula.validator;

import com.gajula.dto.User_Info;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

    private final static Logger admin = LogManager.getLogger(UserFormValidator.class.getName());

    @Override
    public boolean supports(Class<?> user) {
        return User_Info.class.equals(user);
    }

    @Override
    public void validate(Object userObj, Errors errors) {
        admin.info("User Form Validation start");
        User_Info user = (User_Info) userObj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "error.fullname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.phone");
        if(user.getPhone().length() < 10){
            errors.rejectValue("phone", "error.phone");
        }
        admin.info("User Form Validation end");
    }

}
