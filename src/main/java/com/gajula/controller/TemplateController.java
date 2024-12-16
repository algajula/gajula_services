package com.gajula.controller;

import com.gajula.dto.BookDto;
import com.gajula.dto.CountryDto;
import com.gajula.dto.CustomerDto;
import com.gajula.dto.UserDto;
import com.gajula.model.FileMetaData;
import com.gajula.model.ResponseBean;
import com.gajula.repository.BookRepository;
import com.gajula.repository.CustomerRespository;
import com.gajula.repository.UserRepository;
import com.gajula.service.AwsS3Service;
import com.gajula.service.CustomerService;
import com.gajula.service.MasterService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.math.BigInteger;
import java.util.Arrays;
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
    AwsS3Service awsS3Service;

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

    @RequestMapping("/createcustomer/{actionType}")
    public String createcustomer(@PathVariable("actionType")String actionType, Model model,
                             HttpServletRequest httpReq) throws Exception{
        admin.info("=== create customer Start ===");
        admin.info("==== actionType ===="+actionType);
        CustomerDto customer = new CustomerDto();
        if(actionType.equalsIgnoreCase("new")){
            model.addAttribute("customer", new CustomerDto());
        }else if(actionType.equalsIgnoreCase("edit")) {
            String custId = (String)httpReq.getParameter("custId");
            admin.info("custId=="+custId);
            customer = (CustomerDto) customerRespository.findById(new BigInteger(custId)).get();
            if ( null !=  customer)
                model.addAttribute("customer", customer);
            else
                model.addAttribute("customer", new CustomerDto());
        }
        admin.info("=== create customer End ===");
        return "createcustomer";
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

    @RequestMapping("/createbook/{actionType}")
    public String createbook(@PathVariable("actionType")String actionType, Model model,
                             HttpServletRequest httpReq) throws Exception{
        admin.info("=== create book Start ===");
        admin.info("==== actionType ===="+actionType);
        BookDto book = new BookDto();
        if(actionType.equalsIgnoreCase("new")){
            model.addAttribute("book", new BookDto());
        }else if(actionType.equalsIgnoreCase("edit")) {
            String bookId = (String)httpReq.getParameter("bookId");
            admin.info("bookId=="+bookId);
            book = (BookDto)bookRepository.findById(new BigInteger(bookId)).get();
            if ( null !=  bookId)
                model.addAttribute("book", book);
            else
                model.addAttribute("book", new BookDto());
        }
        admin.info("=== create book End ===");
        return "createbook";
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

    @RequestMapping("/createuser/{actionType}")
    public String createuser(@PathVariable("actionType")String actionType, Model model,
                             HttpServletRequest httpReq) throws Exception{
        admin.info("=== create user Start ===");
        admin.info("==== actionType ===="+actionType);
        UserDto user = new UserDto();

        List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
        model.addAttribute("professionList", professionList);

        if(actionType.equalsIgnoreCase("new")){
            model.addAttribute("user", new UserDto());
        }else if(actionType.equalsIgnoreCase("edit")) {
            String userId = (String)httpReq.getParameter("userId");
            admin.info("userId=="+userId);
            user = (UserDto) userRepository.findById(new BigInteger(userId)).get();
            if ( null !=  userId)
                model.addAttribute("user", user);
            else
                model.addAttribute("user", new UserDto());
        }
        admin.info("=== create User End ===");
        return "createuser";
    }

    @RequestMapping("/s3fileview/{bucketName}")
    public String s3fileview(@PathVariable("bucketName")String bucketName, Model model,
                             HttpServletRequest httpReq) throws Exception{
        admin.info("=== s3fileview Start ===");
        admin.info("==== bucketName ===="+bucketName);

        if(bucketName.equalsIgnoreCase("all"))
            bucketName = "gajula-test";

        List<FileMetaData> s3files = awsS3Service.getListfromS3Bucket(bucketName);
        model.addAttribute("s3files", s3files);
        admin.info("=== s3fileview End ===");
        return "s3fileview";
    }

    @RequestMapping("/s3fileupload")
    public String s3fileupload(Model model) throws Exception{
        admin.info("=== s3fileupload Start ===");
        FileMetaData metaData = new FileMetaData();
        metaData.setBucketName("gajula-test");
        model.addAttribute("metaData", metaData);
        admin.info("=== s3fileupload End ===");
        return "s3fileupload";
    }

}
