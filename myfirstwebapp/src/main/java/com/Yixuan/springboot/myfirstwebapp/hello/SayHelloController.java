package com.Yixuan.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
//something handle web request
public class SayHelloController {
	@RequestMapping("say-hello")
	// map a url to a methond
	@ResponseBody
	// it will say as it is in the browser
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	@RequestMapping("say-hello-html")
	// map a url to a methond
	@ResponseBody
	// it will say as it is in the browser
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>my first html page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("my first html page");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	//JSP
	// in java src/main/resources/META-INF/resources/WEB-INF/jsp is a default place to store jsp files
	@RequestMapping("say-hello-jsp")
	// map a url to a methond
	public String sayHelloJsp() {
		return "say-hello-jsp";
	}
}
