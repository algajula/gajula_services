package com.gajula.service;

import com.gajula.dto.UserDto;
import com.gajula.model.ResponseBean;
import com.gajula.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final static Logger admin = LogManager.getLogger(UserServiceImpl.class.getName());

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseBean getAllUsers() throws Exception {
        ResponseBean response = new ResponseBean();
        List<UserDto> list = new ArrayList<UserDto>();
        try {
            admin.info("getAllUsers start ");
            list = userRepository.findAll();
            response.setResult(list);
            admin.info("getAllUsers end");
        } catch (Exception e) {
            response.setStatusCode("00");
            response.setStatusDescription("FAILLURE");
            admin.info("error in getAllUsers=" + e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseBean getUserByUserid(String userid) throws Exception {
        ResponseBean response = new ResponseBean();
        List<UserDto> list = new ArrayList<UserDto>();
        try {
            admin.info("getUserByUserid start ");
            list = userRepository.getUserByUserid(userid);
            response.setResult(list);
            admin.info("getUserByUserid end");
        } catch (Exception e) {
            response.setStatusCode("00");
            response.setStatusDescription("FAILLURE");
            admin.info("error in getUserByUserid=" + e.getMessage());
        }
        return response;
    }
}
