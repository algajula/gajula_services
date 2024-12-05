package com.gajula.service;

import com.gajula.dto.CityDto;
import com.gajula.dto.CountryDto;
import com.gajula.dto.StateDto;

import java.math.BigInteger;
import java.util.List;

public interface MasterService {

    public List<CountryDto> getAllCountries() throws Exception;
    public CountryDto getCountriesByCountryCode(BigInteger countryCode) throws Exception;

    public List<StateDto> getAllStates() throws Exception;
    public StateDto getStatesByStateCode(BigInteger stateCode) throws Exception;

    public List<CityDto> getAllCities() throws Exception;
    public CityDto getCitiesByCityCode(BigInteger cityCode) throws Exception;

}
