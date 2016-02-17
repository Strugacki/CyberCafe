package com.ug.cyberCafe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ug.cyberCafe.service.UserService;
import com.ug.cyberCafe.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String myPage(Model model){
		
		
		return "profile";		
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password, HttpSession session){
		User toLogIn = userService.loginUser(login, password);
		
		
		return "login";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginError(Model model){
		model.addAttribute("error",true);
		return "login";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String getAddNewUserForm(Model model){
		User newUser = new User();
		model.addAttribute("newUser", newUser);
		return "registration";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String processAddNewUserForm(@ModelAttribute("newUser") User newUser){
		newUser.setActive(true);
		userService.addUser(newUser);
		return "redirect:/user" ;
	}
	
	
}
	
