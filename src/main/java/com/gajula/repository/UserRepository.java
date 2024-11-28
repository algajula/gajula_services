package com.gajula.repository;

import com.gajula.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDto, BigInteger> {

    @Query(value = "SELECT b FROM UserDto b WHERE b.userid = :userid")
    public List<UserDto> getUserByUserid(String userid);

}
