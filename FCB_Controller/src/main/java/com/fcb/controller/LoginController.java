package com.fcb.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="loginPage",method=RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String homePage(){
		return "balanceenquery";
	}
	@RequestMapping(value="failureUrl", method = { RequestMethod.GET })
	public String failurePage(Map<String,String> map){
		String response="Invalid Username OR Password";
		map.put("response", response);
		return "invalidpage";
	}
	@RequestMapping(value="balanceenquery", method = { RequestMethod.GET })
	public String balanceEnqueryPage(Map<String,String> map){
		return "balanceenquery";
	}
	
}
