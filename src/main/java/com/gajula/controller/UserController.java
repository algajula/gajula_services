package com.gajula.controller;

import com.gajula.dto.UserDto;
import com.gajula.exception.CustomException;
import com.gajula.model.ResponseBean;
import com.gajula.service.UserService;
import com.gajula.validator.UserFormValidator;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/v1/user/")
public class UserController {

    private final static Logger admin = LogManager.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true, 10));
    }

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


    @PostMapping("/saveuser")
    public String saveuser(@Valid @ModelAttribute("user") UserDto user,
                             BindingResult bindingResult, Model model) {
        admin.info("====saveuser form====");
        admin.info(user);
        userFormValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            admin.info("In validation check");
            List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
            model.addAttribute("professionList", professionList);
            return "createuser";
        }
        admin.info("====saveuser form save end ====");
        return "registersuccess";
    }

}
