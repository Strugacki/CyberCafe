package com.ug.cyberCafe.controller;

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

import com.ug.cyberCafe.service.NewsService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	final static Logger LOGGER = Logger.getLogger(HomeController.class);
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping
	public String welcome(Model model){
		newsService.authorization(model);
		if(!newsService.getAllNews().isEmpty()){
			model.addAttribute("news",newsService.getAllNews());
		}
		
		return "home";
	}
	
	@RequestMapping("about")
	public String about(Model model){
		newsService.authorization(model);
		
		return "about";
	}
	
	@RequestMapping("contact")
	public String contact(Model model){
		newsService.authorization(model);
		
		return "contact";
	}
	
	@RequestMapping("pricing")
	public String pricing(Model model){
		newsService.authorization(model);
		
		return "pricing";
	}
	
	@RequestMapping("promotions")
	public String promotions(Model model){
		newsService.authorization(model);
		
		return "promotions";
	}
	
	@RequestMapping("events")
	public String tournaments(Model model){
		newsService.authorization(model);
		
		return "events";
	}
}
