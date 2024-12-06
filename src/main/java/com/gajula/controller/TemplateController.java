package com.gajula.controller;

import com.gajula.dto.BookDto;
import com.gajula.dto.CountryDto;
import com.gajula.dto.CustomerDto;
import com.gajula.dto.UserDto;
import com.gajula.model.ResponseBean;
import com.gajula.repository.BookRepository;
import com.gajula.repository.CustomerRespository;
import com.gajula.repository.UserRepository;
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

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

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

    @RequestMapping("/bookview")
    public String bookview(Model model) throws Exception{
        admin.info("=== book view Start ===");
        admin.info("==== All ====");
        List<BookDto> bookList = bookRepository.findAll();
        model.addAttribute("book", new BookDto());
        model.addAttribute("bookList", bookList);
        admin.info("bookList size=="+bookList.size());
        admin.info("=== book view End ===");
        return "bookview";
    }

    @RequestMapping("/userview")
    public String userview(Model model) throws Exception{
        admin.info("=== user view Start ===");
        admin.info("==== All ====");
        List<UserDto> userList = userRepository.findAll();
        model.addAttribute("user", new UserDto());
        model.addAttribute("userList", userList);
        admin.info("bookList size=="+userList.size());
        admin.info("=== user view End ===");
        return "bookview";
    }

}
