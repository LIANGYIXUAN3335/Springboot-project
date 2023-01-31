package com.Yixuan.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SessionAttributes("name")
public class LoginController {
	private AuthenticationService authenticationservice;
	public LoginController(AuthenticationService authenticationservice) {
			super();
			this.authenticationservice = authenticationservice;
		}
	//	private Logger logger = LoggerFactory.getLogger(getClass());
	@RequestMapping(value = "login", method = RequestMethod.GET)
	// map a url to a methond
//	public String gotoLoginPage(@RequestParam String name,ModelMap model) {
	public String gotoLoginPage() {	
//		model.put("name", name);
//		logger.debug("request param is {}",name);
//		logger.info("i want this printed at info level {}",name);
//		logger.warn("i want this printed at warn level {}",name);
		return "login";
		}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	// map a url to a methond
	public String gotoWelcome(@RequestParam String name,@RequestParam String password,ModelMap model) {
		model.put("name", name);
//		model.put("password", password);
//		logger.debug("request param is {}",name);
//		logger.info("i want this printed at info level {}",name);
//		logger.warn("i want this printed at warn level {}",name);
		// authentication if there is name and password to welcome
		// else login page
		if (authenticationservice.authenticate(name,password)) {
			return "welcome";
		}
		model.put("errormessage","invalid input,please try again" );
		return "login";
		}
}
