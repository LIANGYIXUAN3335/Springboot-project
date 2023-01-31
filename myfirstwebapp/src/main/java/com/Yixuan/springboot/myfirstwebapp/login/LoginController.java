package com.Yixuan.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@RequestMapping("login")
	// map a url to a methond
	public String gotoLoginPage(@RequestParam String name,ModelMap model) {
		model.put("name", name);
		logger.debug("request param is {}",name);
		logger.info("i want this printed at info level {}",name);
		logger.warn("i want this printed at warn level {}",name);
		return "login";
		}

}
