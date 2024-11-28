package com.gajula.util;

import com.gajula.model.RequestBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class APIConstants {

    private final static Logger admin = LogManager.getLogger("admin");

    public static final String DATA_ERR_CODE = "02";
    public static final String DATA_ERR_DESC = "ERR";


    @SuppressWarnings("deprecation")
    public static ObjectMapper getObjectMapper() {
	ObjectMapper mapper = new ObjectMapper();
		// mapper.enable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
		mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES, true);
		mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
		mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		return mapper;
    }

    public static RequestBean convertrequestToBean(String reqStr) {
		RequestBean request = new RequestBean();
	try {
	    request = getObjectMapper().readValue(reqStr, RequestBean.class);
	} catch (Exception e) {
	    admin.error("error while conversion to bean===" + e.getMessage());
	    return request;
	}
	return request;
    }

}
