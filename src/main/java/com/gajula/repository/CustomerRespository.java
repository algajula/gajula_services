package com.gajula.repository;

import com.gajula.dto.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface CustomerRespository extends JpaRepository<CustomerDto, BigInteger>{

	
	@Query(value = "SELECT c FROM CustomerDto c")
	public List<CustomerDto> getAllCustomer();
}
