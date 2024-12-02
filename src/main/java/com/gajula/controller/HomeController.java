package com.gajula.controller;


import com.gajula.dto.User_Info;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;


@Controller
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

	private final static Logger admin = LogManager.getLogger("admin");
	
	@RequestMapping("/")
	public String welcome() {
		admin.info("===WELCOME START===");
		admin.info("===WELCOME END===");
		return "welcome";
	}

	@GetMapping("/userregister")
	public String userregister(Model model) throws Exception{
		User_Info user = new User_Info();
		try{
			admin.info("userregister start");
			user.setFullName("Gajula Allabakash");
			model.addAttribute("user", user);
			List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
			model.addAttribute("professionList", professionList);
			admin.info("userregister end");
		}catch (Exception e){
			admin.error("userregister error "+e.getMessage());
		}
		return "userregister";
	}

}
