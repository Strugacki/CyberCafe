package com.ug.cyberCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ug.cyberCafe.dao.UserDao;
import com.ug.cyberCafe.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao UserDao;
	
	/**
	 * 
	 */
	@RequestMapping(value = { "/registration"}, method = RequestMethod.GET)
	public String getAddNewUserForm(Model model){
		User newUser = new User();
		model.addAttribute("newUser", newUser);
		return "registration";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = {"/reqistration"}, method = RequestMethod.POST)
	public String processAddNewUserForm(@ModelAttribute("newUser") User newUser){
		UserDao.addUser(newUser);
		return "redirect:/user" ;
	}
	
	
}
	
