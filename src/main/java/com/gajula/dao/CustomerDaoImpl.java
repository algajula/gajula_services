package com.gajula.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.gajula.dto.CustomerDto;
import com.gajula.dto.VehicleDto;
import com.gajula.repository.CustomerRespository;
import com.gajula.repository.VehicleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    private final static Logger admin = LogManager.getLogger(CustomerDaoImpl.class.getName());

    @Autowired
    CustomerRespository customerRespository;

    @Autowired
    VehicleRespository vehicleRespository;

    @PersistenceContext(name = "train")
    @Qualifier(value = "trainEntityManager")
    private EntityManager em;

    @Override
    public List<CustomerDto> getCustomerDetails() {
	List<CustomerDto> list = new ArrayList<CustomerDto>();
	try {
	    admin.info("getCustomerDetails start---");
	    list = customerRespository.getAllCustomer();
	    admin.info("list size==" + list.size());
	    admin.info("getCustomerDetails end---");
	    ;
	} catch (Exception e) {
	    admin.error("error occured in getCustomerDetails  " + e.getMessage());
	    //throw new TrainCustomeException("error occured in getCustomerDetails  "+e.getMessage());
	}
	return list;
    }

    @Override
    public List<VehicleDto> getVehicleDetails() {
	List<VehicleDto> list = new ArrayList<VehicleDto>();
	try {
	    admin.info("getVehicleDetails start---");
	    list = vehicleRespository.getAllVehicles();
	    admin.info("list size==" + list.size());
	    admin.info("getVehicleDetails end---");
	    ;
	} catch (Exception e) {
	    admin.error("error occured in getVehicleDetails  " + e.getMessage());
	    //throw new TrainCustomeException("error occured in getVehicleDetails  "+e.getMessage());
	}
	return list;
    }
    
    @Override
    public boolean saveCustomerDetails(CustomerDto customer) {
	try {
	    admin.info("saveCustomerDetails start---");
	    //CustomerDto obj = (CustomerDto) trainCustomerRespository.save(customer);
	    CustomerDto obj = (CustomerDto) em.merge(customer);
	    admin.info("generated ID===" + obj.getCust_uid());
	    admin.info("saveCustomerDetails end---");
	} catch (Exception e) {
	    admin.error("error occured in saveCustomerDetails  " + e.getMessage());
	    return false;
	}
	return true;
    }

}
