package com.gajula.controller;

import com.gajula.exception.CustomException;
import com.gajula.model.ResponseBean;
import com.gajula.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final static Logger admin = LogManager.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean getAllUsers() throws Exception {
        ResponseBean response = new ResponseBean();
        try {
            admin.info("===getAllUsers START===");
            response = userService.getAllUsers();
            admin.info("===getAllUsers END===");
        } catch (Exception e) {
            throw new CustomException("error occured in getAllUsers service" + e.getMessage());
        }
        return response;
    }


    @GetMapping(value = "/getUserByUserid/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean getAllUsers(@PathVariable("userid") String userid) throws Exception {
        ResponseBean response = new ResponseBean();
        try {
            admin.info("===getUserByUserid START===");
            response = userService.getUserByUserid(userid);
            admin.info("===getUserByUserid END===");
        } catch (Exception e) {
            throw new CustomException("error occured in getUserByUserid service" + e.getMessage());
        }
        return response;
    }
}
