package com.gajula.controller;

import com.gajula.exception.CustomException;
import com.gajula.model.ResponseBean;
import com.gajula.service.CustomerService;
import com.gajula.dto.CustomerDto;
import com.gajula.util.APIConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerRestController {

	private final static Logger admin = LogManager.getLogger(CustomerRestController.class.getName());

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/getCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getCustomer() throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getCustomer START===");
			response = customerService.getCustomerDetails();
			admin.info("===END===");
		} catch (Exception e) {
			throw new CustomException("error occured in getCustomer service" + e.getMessage());
		}
		return response;
	}

	@GetMapping(value = "/getCustomer/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getCustomerByID(@PathVariable(required = false)String custId) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getCustomer START==="+custId);
			if(StringUtils.isEmpty(custId) || "All".equalsIgnoreCase(custId)){
				response = customerService.getCustomerDetails();
			}else{
				response = customerService.getCustomerDetailsById(Long.valueOf(custId));
			}
			admin.info("===END===");
		} catch (Exception e) {
			throw new CustomException("error occured in getCustomer service" + e.getMessage());
		}
		return response;
	}

	@GetMapping(value = "/getVehicle", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getVehicle() throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getVehicle START===");
			response = customerService.getvehicleDetails();
			admin.info("===getVehicle END===");
		} catch (Exception e) {
			throw new CustomException("error occured in getVehicle service" + e.getMessage());
		}
		return response;
	}

	@PostMapping(value = "/saveCustomer/{actionType}", produces = "application/json", consumes = "application/json")
	public ResponseBean saveCustomer(@PathVariable("actionType") String actionType,
				@RequestBody(required = true) String reqStr) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("saveCustomer start actionType==="+actionType);
			CustomerDto customer = APIConstants.getObjectMapper().readValue(reqStr,CustomerDto.class);
			admin.info("request=======" + customer.getCreatedDate());
			boolean updtedFlag = customerService.saveCustomerDetails(customer);
			if (updtedFlag) {
				response.setStatusCode(APIConstants.STATUS_SUCCESS_CODE);
				response.setStatusDescription(APIConstants.STATUS_SUCCESS_DESC);
				response.setResult("Customer saved successfully! " + updtedFlag);
			} else {
				response.setStatusCode(APIConstants.DATA_ERR_CODE);
				response.setStatusDescription(APIConstants.DATA_ERR_DESC);
				response.setResult("error while save customer data! " + updtedFlag);
			}
			admin.info("===saveCustomer END===" + updtedFlag);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("error occured in saveCustomer service" + e.getMessage());
		}
		return response;
	}
}
