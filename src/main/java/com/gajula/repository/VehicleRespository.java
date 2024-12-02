package com.gajula.repository;

import com.gajula.dto.VehicleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface VehicleRespository extends JpaRepository<VehicleDto, BigInteger>{

	
	@Query(value = "SELECT c FROM VehicleDto c")
	public List<VehicleDto> getAllVehicles();
}

