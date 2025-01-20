package com.gajula.util;

import com.gajula.dto.AddressDto;
import com.gajula.dto.UserDto;
import com.gajula.dto.UserPwdDto;
import com.gajula.model.RequestBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

public class APIConstants {

    private final static Logger admin = LogManager.getLogger(APIConstants.class.getName());

	public static String STATUS_SUCCESS_CODE="00";
	public static String STATUS_SUCCESS_DESC="SUCCESS";
	public static String STATUS_FAILURE_CODE = "01";
	public static String STATUS_FAILURE_DESC = "FAILURE";
	public static final String DATA_ERR_CODE = "02";
    public static final String DATA_ERR_DESC = "ERR";
	public static final String DATA_TIMEOUT_CODE = "03";
	public static final String DATA_TIMEOUT_DESC = "TIMEOUT";
	public static final String DATA_VALIDATION_CODE = "04";
	public static final String DATA_VALIDATION_DESC = "VALIDATION";

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

	public static UserDto convertrequestToUserDto(String payload){
		UserDto userdto = new UserDto();
		try {
			userdto = getObjectMapper().readValue(payload, UserDto.class);
		} catch (Exception e) {
			admin.error("error while conversion to user info ===" + e.getMessage());
			return userdto;
		}
		return userdto;
	}

	public static UserPwdDto convertrequestToUserPwdDto(String payload){
		UserPwdDto userpwddto = new UserPwdDto();
		try {
			userpwddto = getObjectMapper().readValue(payload, UserPwdDto.class);
		} catch (Exception e) {
			admin.error("error while conversion to UserPwd info ===" + e.getMessage());
			return userpwddto;
		}
		return userpwddto;
	}

	public static AddressDto convertrequestToAddressinfo(String payload){
		AddressDto addrinfo = new AddressDto();
		try {
			addrinfo = getObjectMapper().readValue(payload, AddressDto.class);
		} catch (Exception e) {
			admin.error("error while conversion to Address info ===" + e.getMessage());
			return addrinfo;
		}
		return addrinfo;
	}

	public static String getFileExtension(String fileName) {
		if (StringUtils.isEmpty(fileName) || !fileName.contains(".") || fileName.endsWith("."))
			return null;
		else
			return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	public static String getBaseFileName(String fileName) {
		if (StringUtils.isEmpty(fileName) || !fileName.contains(".") || fileName.endsWith("."))
			return null;
		else
			return fileName.substring(0,fileName.lastIndexOf("."));
	}
}
