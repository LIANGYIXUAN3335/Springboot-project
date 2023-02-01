package com.Yixuan.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	// map a url to a methond
//	public String gotoWelcome(@RequestParam String name,@RequestParam String password,ModelMap model) {
//		model.put("name", name);
////		model.put("password", password);
////		logger.debug("request param is {}",name);
////		logger.info("i want this printed at info level {}",name);
////		logger.warn("i want this printed at warn level {}",name);
//		// authentication if there is name and password to welcome
//		// else login page
//		if (authenticationservice.authenticate(name,password)) {
//			return "welcome";
//		}
//		model.put("errormessage","invalid input,please try again" );
//		return "login";
//		}

