package com.gajula.repository;

import com.gajula.dto.CityDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<CityDto, BigInteger> {

}
