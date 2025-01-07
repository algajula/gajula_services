package com.gajula.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.gajula.model.ResponseBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private final static Logger admin = LogManager.getLogger(CustomAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, 
	AccessDeniedException accessDeniedException) throws IOException, ServletException {
		admin.info("403 FORBIDDEN CUSTOME");
		admin.info("accessDeniedException==="+accessDeniedException.getMessage());
		admin.info("accessDeniedException==="+accessDeniedException.getCause());
		ResponseBean res = new ResponseBean();
		res.setStatusCode("403");
		res.setStatusDescription("FORBIDDEN");
		String json = new ObjectMapper().writeValueAsString(res);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
    
}