package com.gajula.service;

import com.gajula.dao.CustomerDao;
import com.gajula.model.ResponseBean;
import com.gajula.repository.CustomerRespository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.gajula.dto.CustomerDto;
import com.gajula.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final static Logger admin = LogManager.getLogger(CustomerServiceImpl.class.getName());

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CustomerRespository customerRespository;

    @Override
    public ResponseBean getCustomerDetails() throws Exception {
        ResponseBean response = new ResponseBean();
        List<CustomerDto> list = new ArrayList<CustomerDto>();
        try {
            admin.info("getCustomerDetails start");
            list = customerDao.getCustomerDetails();
            //list = getCustomerList();
            for (CustomerDto cust : list) {
                admin.info("record=======" + cust.getCustNumber());
                Set<VehicleDto> vehList = cust.getVehicleList();
                for (VehicleDto veh : vehList) {
                    admin.info("VEHICLE----" + veh.getVeh_uid() + "==" + veh.getVrn() + "==" + veh.getVin());
                }
            }
            response.setResult(list);
            admin.info("getCustomerDetails start");
        } catch (Exception e) {
            response.setStatusCode("00");
            response.setStatusDescription("FAILLURE");
            admin.info("error in getCustomerDetails=" + e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseBean getCustomerDetailsById(Long custId) throws Exception {
        ResponseBean response = new ResponseBean();
        List<CustomerDto> list = new ArrayList<CustomerDto>();
        try {
            admin.info("getCustomerDetails start "+custId);
            list = customerRespository.getCustomerByNumber(custId);
            response.setResult(list);
            admin.info("getCustomerDetails start");
        } catch (Exception e) {
            response.setStatusCode("00");
            response.setStatusDescription("FAILLURE");
            admin.info("error in getCustomerDetails=" + e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseBean getvehicleDetails() throws Exception {
        ResponseBean response = new ResponseBean();
        List<VehicleDto> list = new ArrayList<VehicleDto>();
        try {
            admin.info("getvehicleDetails start");
            list = customerDao.getVehicleDetails();
            for (VehicleDto veh : list) {
                admin.info("veh record=======" + veh.getVin());
                CustomerDto cust = veh.getCustomer();
                admin.info("cust record=======" + cust.getCustName());
            }
            response.setResult(list);
            admin.info("getvehicleDetails start");
        } catch (Exception e) {
            response.setStatusCode("00");
            response.setStatusDescription("FAILLURE");
            admin.info("error in getvehicleDetails=" + e.getMessage());
        }
        return response;
    }

    @Override
    public boolean saveCustomerDetails(CustomerDto customer, String actionType) throws Exception {
        boolean flag = false;
        CustomerDto persistCust = new CustomerDto();
        Set<VehicleDto> vehList = new HashSet<VehicleDto>();
        try {
            admin.info("saveCustomerDetails start");
            if(actionType.equalsIgnoreCase("edit")){
                admin.info("======= EDIT ==================");
                admin.info("Existing before fetch request customer ID===="+customer.getCust_uid());
                persistCust = customerRespository.findById(customer.getCust_uid()).get();
                admin.info("Existing after fetch customer ID===="+persistCust.getCust_uid());
                persistCust.setCustName(customer.getCustName());
                persistCust.setCustNumber(customer.getCustNumber());
                persistCust.setEmailAddress(customer.getEmailAddress());
                persistCust.setPhone(customer.getPhone());
                persistCust.setCreatedDate(customer.getCreatedDate());
                persistCust.setModifiedDate(customer.getModifiedDate());
                vehList.addAll(customer.getVehicleList());
                persistCust.setVehicleList(vehList);
                flag = customerDao.saveCustomerDetails(persistCust);
                admin.info("updated existing customer successfully========"+flag);
            }else if(actionType.equalsIgnoreCase("add")){
                admin.info("======= ADD ==================");
                persistCust.setCustName(customer.getCustName());
                persistCust.setCustNumber(customer.getCustNumber());
                persistCust.setEmailAddress(customer.getEmailAddress());
                persistCust.setPhone(customer.getPhone());
                persistCust.setCreatedDate(customer.getCreatedDate());
                persistCust.setModifiedDate(customer.getModifiedDate());
                vehList.addAll(customer.getVehicleList());
                persistCust.setVehicleList(vehList);
                CustomerDto custObj = customerRespository.save(customer);
                admin.info("new customer added successfully========"+custObj.getCust_uid());
            }
            admin.info("saveCustomerDetails start");
        } catch (Exception e) {
            e.printStackTrace();
            admin.info("error in saveCustomerDetails=" + e.getMessage());
        }
        return flag;
    }

    public List<CustomerDto> getCustomerList() {
        List<CustomerDto> list = new ArrayList<CustomerDto>();
        Set<VehicleDto> vehList = new HashSet<VehicleDto>();
        CustomerDto cust = new CustomerDto();
        VehicleDto veh = new VehicleDto();
        veh.setVeh_uid(new BigInteger("1111"));
        veh.setVin("vin1101");
        veh.setVrn("vrn1101");
        cust.setCust_uid(new BigInteger("1111"));
        cust.setEmailAddress("test@gmail.com");
        cust.setCustName("TEST");
        cust.setCustNumber(Long.valueOf(1101));
        cust.setPhone(1111 - 1111 - 1111);
        vehList.add(veh);
        cust.setVehicleList(vehList);
        list.add(cust);
        return list;
    }
}
