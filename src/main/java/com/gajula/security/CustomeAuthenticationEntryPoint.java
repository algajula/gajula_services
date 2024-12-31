package com.gajula.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gajula.model.ResponseBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomeAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private final static Logger admin = LogManager.getLogger(CustomeAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// 401, 403
		admin.info("401 UN-AUTHORIZED "+authException.getLocalizedMessage());
		ResponseBean res = new ResponseBean();
		res.setStatusCode("401");
		res.setStatusDescription("UN-AUTHORIZED");
		String json = new ObjectMapper().writeValueAsString(res);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}