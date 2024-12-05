package com.gajula.controller;

import com.gajula.dto.CityDto;
import com.gajula.dto.CountryDto;
import com.gajula.dto.StateDto;
import com.gajula.model.ResponseBean;
import com.gajula.service.MasterService;
import com.gajula.util.APIConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/master/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MasterRestController {

    private final static Logger admin = LogManager.getLogger(MasterRestController.class.getName());

    @Autowired
    MasterService masterService;

    @GetMapping(value = "/getCountries/{countryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean getCountries(@PathVariable("countryCode") String countryCode, HttpServletRequest httpReq) throws Exception {
        ResponseBean response = new ResponseBean();
        try{
            admin.info("getCountries start countryCode="+countryCode);
            if(countryCode.equalsIgnoreCase("All")){
                admin.info("==== All ====");
                List<CountryDto> countryList = masterService.getAllCountries();
                admin.info("countryList size=="+countryList.size());
                response.setResult(countryList);
            }else{
                admin.info("==== ByID ====");
                CountryDto country = masterService.getCountriesByCountryCode(new BigInteger(countryCode));
                response.setResult(country);
            }
            admin.info("getCountries end");
            return response;
        }catch (Exception e){
            response.setStatusCode(APIConstants.DATA_ERR_CODE);
            response.setStatusDescription(APIConstants.DATA_ERR_DESC);
            response.setResult("error while retries countries data! ");
            admin.error("getCountries error "+e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/getStates/{stateCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean getStates(@PathVariable("stateCode") String stateCode, HttpServletRequest httpReq) throws Exception {
        ResponseBean response = new ResponseBean();
        try{
            admin.info("getStates start getStates="+stateCode);
            if(stateCode.equalsIgnoreCase("All")){
                admin.info("==== All ====");
                List<StateDto> statesList = masterService.getAllStates();
                admin.info("statesList size=="+statesList.size());
                response.setResult(statesList);
            }else{
                admin.info("==== ByID ====");
                StateDto state = masterService.getStatesByStateCode(new BigInteger(stateCode));
                response.setResult(state);
            }
            admin.info("getStates end");
            return response;
        }catch (Exception e){
            response.setStatusCode(APIConstants.DATA_ERR_CODE);
            response.setStatusDescription(APIConstants.DATA_ERR_DESC);
            response.setResult("error while retries getStates data! ");
            admin.error("getStates error "+e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/getCities/{cityCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean getCities(@PathVariable("cityCode") String cityCode, HttpServletRequest httpReq) throws Exception {
        ResponseBean response = new ResponseBean();
        try{
            admin.info("getCities start cityCode="+cityCode);
            if(cityCode.equalsIgnoreCase("All")){
                admin.info("==== All ====");
                List<CityDto> citiesList = masterService.getAllCities();
                admin.info("citiesList size=="+citiesList.size());
                response.setResult(citiesList);
            }else{
                admin.info("==== ByID ====");
                CityDto city = masterService.getCitiesByCityCode(new BigInteger(cityCode));
                response.setResult(city);
            }
            admin.info("getCities end");
            return response;
        }catch (Exception e){
            response.setStatusCode(APIConstants.DATA_ERR_CODE);
            response.setStatusDescription(APIConstants.DATA_ERR_DESC);
            response.setResult("error while retries getStates data! ");
            admin.error("getCities error "+e.getMessage());
        }
        return response;
    }
}
