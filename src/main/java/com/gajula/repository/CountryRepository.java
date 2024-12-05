package com.gajula.repository;

import com.gajula.dto.CountryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<CountryDto, BigInteger> {

    @Query(value = "SELECT b FROM CountryDto b WHERE b.countryCode = :countryCode")
    public List<CountryDto> getCountryByCountryCode(BigInteger countryCode);

}
