package com.ug.cyberCafe.controller;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ug.cyberCafe.service.RoleService;
import com.ug.cyberCafe.service.UserService;
import com.ug.cyberCafe.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model){
		Authorization(model);
		return "/user/login";
	}
	
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/user/login?logout";
	}
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(Model model){
            User currentUser = userService.getUserByUsername(getPrincipal());
            Authorization(model);
            model.addAttribute("currentUser",currentUser);
    	
    	return "/user/profile";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String getAddNewUserForm(Model model){
		User newUser = new User();
		newUser.setActive(true);
		model.addAttribute("newUser", newUser);
		Authorization(model);
		return "/user/registration";
	}
	
	/**
	 * @throws IOException 
	 * @throws HibernateException 
	 * 
	 */
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String processAddNewUserForm(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model) throws HibernateException, IOException{
		//@RequestParam("avatar") MultipartFile file
		if(result.hasErrors()){
			model.addAttribute("warn","Nie udało się wykonać rejestracji, spróbuj ponownie!");
			System.out.println(result.toString());
			return "/user/registration";
		}else{
			newUser.setRole(roleService.getRoleByName("ROLE_USER"));
			//SessionFactory session = null;
			//Blob blob = Hibernate.getLobCreator(session.getCurrentSession()).createBlob(file.getBytes());
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
	
	private Model Authorization(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( !(auth instanceof AnonymousAuthenticationToken)){
			model.addAttribute("user",getPrincipal());
			if(auth.getAuthorities() != null){
				for(GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
					String role = authority.getAuthority();
					System.out.println(role);
					model.addAttribute("role",role);
				}
			}
		}else{
			model.addAttribute("user", null);
		}
		
		return model;
	}
	
}
	
