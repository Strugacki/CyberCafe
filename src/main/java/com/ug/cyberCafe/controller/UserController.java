package com.ug.cyberCafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(value = "logins", method = RequestMethod.GET)
	public String logins(){
			return "logins";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/user/login?logout";
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
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
	
	
}
	
