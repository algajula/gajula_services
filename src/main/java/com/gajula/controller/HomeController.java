package com.gajula.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
}
