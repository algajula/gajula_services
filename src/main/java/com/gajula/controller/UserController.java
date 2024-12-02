package com.gajula.controller;

import com.gajula.dto.User_Info;
import com.gajula.exception.CustomException;
import com.gajula.model.ResponseBean;
import com.gajula.service.UserService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User_Info user,
                             BindingResult bindingResult, Model model) {
        admin.info("Professing form...");
        admin.info(user);
        if (bindingResult.hasErrors()) {
            List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
            model.addAttribute("professionList", professionList);
            return "register_form";
        }
        return "register_success";
    }

}
