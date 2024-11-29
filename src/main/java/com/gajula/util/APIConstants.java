package com.gajula.util;

import com.gajula.dto.Address_Info;
import com.gajula.dto.UserPwd_Info;
import com.gajula.dto.User_Info;
import com.gajula.model.RequestBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class APIConstants {

    private final static Logger admin = LogManager.getLogger("admin");

    public static final String DATA_ERR_CODE = "02";
    public static final String DATA_ERR_DESC = "ERR";
	public static final String DATA_TIMEOUT_CODE = "03";
	public static final String DATA_TIMEOUT_DESC = "TIMEOUT";
	public static String STATUS_FAILURE_CODE = "02";
	public static String STATUS_FAILURE_DESC = "FAILURE";
	public static String STATUS_SUCCESS_CODE="00";
	public static String STATUS_SUCCESS_DESC="SUCCESS";

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

	public static User_Info convertrequestToUserDto(String payload){
		User_Info userdto = new User_Info();
		try {
			userdto = getObjectMapper().readValue(payload, User_Info.class);
		} catch (Exception e) {
			admin.error("error while conversion to user info ===" + e.getMessage());
			return userdto;
		}
		return userdto;
	}

	public static UserPwd_Info convertrequestToUserPwdDto(String payload){
		UserPwd_Info userpwddto = new UserPwd_Info();
		try {
			userpwddto = getObjectMapper().readValue(payload, UserPwd_Info.class);
		} catch (Exception e) {
			admin.error("error while conversion to UserPwd info ===" + e.getMessage());
			return userpwddto;
		}
		return userpwddto;
	}

	public static Address_Info convertrequestToAddressinfo(String payload){
		Address_Info addrinfo = new Address_Info();
		try {
			addrinfo = getObjectMapper().readValue(payload, Address_Info.class);
		} catch (Exception e) {
			admin.error("error while conversion to Address info ===" + e.getMessage());
			return addrinfo;
		}
		return addrinfo;
	}

}
