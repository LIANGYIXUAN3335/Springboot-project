package com.Yixuan.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "Hello,world";
	}
	@GetMapping(path = "/hello-world-bean")
	public HelloworldBean helloworldBean() {
		return new HelloworldBean("Hello,world");
	}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloworldBean helloworldPathVariable(@PathVariable String name) {
		return new HelloworldBean(String.format("Hello world, %s", name));
	}
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
	}
}
