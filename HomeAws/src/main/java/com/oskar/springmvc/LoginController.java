package com.oskar.springmvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(){
		return"/WEB-INF/views/login.jsp";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
		if(!service.validateUser(name, password)){
			modelMap.put("errorMessage", "HEY MAN NOT VERY GOOD NO");
			return "/WEB-INF/views/login.jsp";
		}
		
		modelMap.put("name", name);
		modelMap.put("password", password);
		return "/WEB-INF/views/welcome.jsp";
		
	}
	
	
}
