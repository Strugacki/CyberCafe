package com.ug.cyberCafe.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ug.cyberCafe.service.RoleService;
import com.ug.cyberCafe.service.UserService;
import com.ug.cyberCafe.domain.Role;
import com.ug.cyberCafe.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping
	public String myPage(Model model){
		
		
		return "profile";		
	}
	
	@RequestMapping(value = "login")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password, HttpSession session){
		System.out.println(login);
		System.out.println(password);
		User toLogIn = userService.loginUser(login, password);
		if(!(toLogIn == null)){
		session.setAttribute("user", toLogIn);
		User us = (User) session.getAttribute("user");
		System.out.println(us.getFirstName());
		System.out.println(us.getLastName());
			return "redirect:/";
		}else{
			return "registration";
		}
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
		newUser.setActive(true);
		model.addAttribute("newUser", newUser);
		return "registration";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String processAddNewUserForm(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("warn","Nie udało się wykonać rejestracji, spróbuj ponownie!");
			System.out.println(result.toString());
			return "registration";
		}else{
			newUser.setRole(null);
			newUser.setAddresses(null);
			newUser.setAvatar(null);
			userService.addUser(newUser);
			return "redirect:/" ;
		}
	}
	
	
}
	
