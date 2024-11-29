package com.gajula.repository;

import com.gajula.dto.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User_Info, BigInteger> {

    @Query(value = "SELECT b FROM User_Info b WHERE b.userid = :userid")
    public List<User_Info> getUserByUserid(String userid);

}
