package com.gajula.controller;

import com.gajula.exception.BadRequestException;
import com.gajula.exception.CustomException;
import com.gajula.exception.ExceptionResponse;
import com.gajula.util.APIConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	private final static Logger admin = LogManager.getLogger("admin");
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity handleException(final CustomException exception,
			final HttpServletRequest request) throws IOException {
		ExceptionResponse error = new ExceptionResponse();
		admin.info(":::INTERNAL_SERVER_ERROR::"+exception);
		admin.info(":::MESSAGE:::"+exception.getMessage());
		admin.info(":::SERVICE:::"+exception.getServiceName());
		
		if(exception.getCause() instanceof java.net.UnknownHostException){
			admin.info(":UnknownHostException:"+exception.getMessage());
			error.setStatusCode(APIConstants.DATA_ERR_CODE);
			error.setStatusCodeDesc(APIConstants.DATA_ERR_DESC);
			error.setResult(exception.getServiceName()+" is NOT AVAILABLE -- UNABLE TO CONNECT REDIS CACHE SERVER");
		} else {
			admin.info(":OTHER ERROR:"+exception.getMessage());
			error.setStatusCode(APIConstants.DATA_ERR_CODE);
			error.setStatusCodeDesc(APIConstants.DATA_ERR_DESC);
			error.setResult(exception.getMessage());
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(error);
	}	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity handleResourceNotFound(final NoHandlerFoundException exception,
			final HttpServletRequest request) throws IOException {
		admin.info("handleResourceNotFound ERROR");
		admin.info("The origin server did not find a current representation for the target resource or is not willing to disclose that one exists");
		ExceptionResponse error = new ExceptionResponse();
		error.setStatusCode("404");
		error.setStatusCodeDesc("NOT FOUND");
		error.setResult(request.getRequestURI()+" is NOT AVAILABLE \n");
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(error);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequest(final BadRequestException exception,
			final HttpServletRequest request) throws IOException {
		admin.info("handleBadRequest ERROR");
		ExceptionResponse error = new ExceptionResponse();
		error.setStatusCode("400");
		error.setStatusCodeDesc("BAD REQUEST");
		error.setResult(exception.getServiceName()+" - "+exception.getMessage() );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(error);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleInternalserverError(final CustomException exception,
			final HttpServletRequest request) throws IOException {
		admin.info("handleInternalserverError UNKNOWN SERVER ERROR ERROR");
		ExceptionResponse error = new ExceptionResponse();
		error.setStatusCode("500");
		error.setStatusCodeDesc("INTERNAL_SERVER_ERROR");
		error.setResult("UNKNOWN SYSTEM ERROR OCCURED FOR THE SERVICE "+exception.getServiceName()+" \n");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(error);
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<?> handleMaxSizeException(MaxUploadSizeExceededException exception) {
		admin.info("handleInternalserverError UNKNOWN SERVER ERROR ERROR");
		ExceptionResponse error = new ExceptionResponse();
		error.setStatusCode(exception.getStatusCode().toString());
		error.setStatusCodeDesc("EXPECTATION_FAILED");
		error.setResult("EXPECTATION_FAILED File too large!");
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(error);
	}
}
