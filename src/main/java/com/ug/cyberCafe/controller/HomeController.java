package com.ug.cyberCafe.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ug.cyberCafe.domain.User;
import com.ug.cyberCafe.service.NewsService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	final static Logger LOGGER = Logger.getLogger(HomeController.class);
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping
	public String welcome(Model model){
		if(!newsService.getAllNews().isEmpty()){
			model.addAttribute("news",newsService.getAllNews());
		}
		
		Authorization(model);
		return "home";
	}
	
	@RequestMapping("about")
	public String about(Model model){
		Authorization(model);
		
		return "about";
	}
	
	@RequestMapping("contact")
	public String contact(Model model){
		Authorization(model);
		
		return "contact";
	}
	
	@RequestMapping("pricing")
	public String pricing(Model model){
		Authorization(model);
		
		return "pricing";
	}
	
	@RequestMapping("promotions")
	public String promotions(Model model){
		Authorization(model);
		
		return "promotions";
	}
	
	@RequestMapping("events")
	public String tournaments(Model model){
		Authorization(model);
		
		return "events";
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
					LOGGER.info(role);
					model.addAttribute("role",role);
				}
			}
		}else{
			model.addAttribute("user", null);
		}
		
		return model;
	}
}
