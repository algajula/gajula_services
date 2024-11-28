package com.gajula.repository;

import com.gajula.dto.AuthorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
@Transactional
public interface AuthorRepository  extends JpaRepository<AuthorDto, BigInteger> {

}
