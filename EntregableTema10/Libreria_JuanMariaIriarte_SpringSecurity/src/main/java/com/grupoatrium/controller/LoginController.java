package com.grupoatrium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String mostrarLogin(){
		return "login";
	}
	
	@RequestMapping("/accessDenied")
	public String mostrarAccessDenied(){
		return "accessDenied";
	}

}
