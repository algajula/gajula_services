package com.gajula.validator;

import com.gajula.dto.BookDto;
import com.gajula.model.ValidateForm;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class BookValidator {
    private final static Logger admin = LogManager.getLogger(BookValidator.class.getName());

    public ValidateForm validateForm(BookDto book){
        ValidateForm errorForm = new ValidateForm();
        HashMap<String, String> labels = new HashMap<>();
        if(StringUtils.isEmpty(book.getTitle())){
            labels.put("title","Please fill Title!");
        }
        if(StringUtils.isEmpty(book.getGenre())){
            labels.put("genre","Please fill Genre!");
        }
        if(null != book.getPrice()){
            labels.put("price","Please fill Price!");
        }
        errorForm.setErrorlabels(labels);
        errorForm.setHasRrrors(!labels.isEmpty());
        return errorForm;
    }

}
