package com.gajula.repository;

import com.gajula.dto.CountryDto;
import com.gajula.dto.StateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface StateRepository extends JpaRepository<StateDto, BigInteger> {

    @Query(value = "SELECT b FROM StateDto b WHERE b.stateCode = :stateCode")
    public List<StateDto> getStateByStateCode(BigInteger stateCode);

}