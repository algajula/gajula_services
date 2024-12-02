package com.gajula.dao;

import com.gajula.dto.CustomerDto;
import com.gajula.dto.VehicleDto;

import java.util.List;

public interface CustomerDao {

	public List<CustomerDto> getCustomerDetails();
	public List<VehicleDto> getVehicleDetails();
	public boolean saveCustomerDetails(CustomerDto customer);
}
