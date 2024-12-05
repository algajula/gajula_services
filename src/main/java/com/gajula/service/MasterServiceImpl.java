package com.gajula.service;

import com.gajula.dto.CityDto;
import com.gajula.dto.CountryDto;
import com.gajula.dto.StateDto;
import com.gajula.repository.CityRepository;
import com.gajula.repository.CountryRepository;
import com.gajula.repository.StateRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class MasterServiceImpl implements MasterService{

    private final static Logger admin = LogManager.getLogger(MasterServiceImpl.class.getName());

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CityRepository cityRepository;


    @Override
    public List<CountryDto> getAllCountries() throws Exception {
        List<CountryDto> list = new ArrayList<CountryDto>();
        try {
            admin.info("getAllCountries start ");
            list = countryRepository.findAll();
            admin.info("getAllCountries end");
        } catch (Exception e) {
            admin.info("error in getAllCountries=" + e.getMessage());
        }
        return list;
    }

    @Override
    public CountryDto getCountriesByCountryCode(BigInteger countryCode) throws Exception {
        CountryDto country = new CountryDto();
        try {
            admin.info("getCountriesByCountryCode start ");
            country = countryRepository.findById(countryCode).get();
            admin.info("getCountriesByCountryCode end");
        } catch (Exception e) {
            admin.info("error in getCountriesByCountryCode=" + e.getMessage());
        }
        return country;
    }

    @Override
    public List<StateDto> getAllStates() throws Exception {
        List<StateDto> list = new ArrayList<StateDto>();
        try {
            admin.info("getAllStates start ");
            list = stateRepository.findAll();
            admin.info("getAllStates end");
        } catch (Exception e) {
            admin.info("error in getAllStates=" + e.getMessage());
        }
        return list;
    }

    @Override
    public StateDto getStatesByStateCode(BigInteger stateCode) throws Exception {
        StateDto state = new StateDto();
        try {
            admin.info("getStatesByStateCode start ");
            state = stateRepository.findById(stateCode).get();
            admin.info("getStatesByStateCode end");
        } catch (Exception e) {
            admin.info("error in getStatesByStateCode=" + e.getMessage());
        }
        return state;
    }

    @Override
    public List<CityDto> getAllCities() throws Exception {
        List<CityDto> list = new ArrayList<CityDto>();
        try {
            admin.info("getAllCities start ");
            list = cityRepository.findAll();
            admin.info("getAllCities end");
        } catch (Exception e) {
            admin.info("error in getAllCities=" + e.getMessage());
        }
        return list;
    }

    @Override
    public CityDto getCitiesByCityCode(BigInteger cityCode) throws Exception {
        CityDto city = new CityDto();
        try {
            admin.info("getCitiesByCityCode start ");
            city = cityRepository.findById(cityCode).get();
            admin.info("getCitiesByCityCode end");
        } catch (Exception e) {
            admin.info("error in getCitiesByCityCode=" + e.getMessage());
        }
        return city;
    }
}
