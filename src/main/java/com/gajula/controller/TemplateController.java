package com.gajula.controller;

import com.gajula.dto.CountryDto;
import com.gajula.dto.CustomerDto;
import com.gajula.model.ResponseBean;
import com.gajula.repository.CustomerRespository;
import com.gajula.service.CustomerService;
import com.gajula.service.MasterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/templates/")
public class TemplateController {

    private final static Logger admin = LogManager.getLogger("admin");

    @Autowired
    MasterService masterService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRespository customerRespository;

    @RequestMapping("/customerview")
    public String customerview(Model model) throws Exception{
        admin.info("=== Customer view Start ===");
        admin.info("==== All ====");
        List<CustomerDto> custList = customerRespository.findAll();
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("custList", custList);
        admin.info("custList size=="+custList.size());
        admin.info("=== Customer view End ===");
        return "customerview";
    }
}
