package com.ug.cyberCafe.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping
	public String welcome(Model model){
		
		return "home";
	}
	
	@RequestMapping("about")
	public String about(Model model){
		
		
		return "about";
	}
	
	@RequestMapping("contact")
	public String contact(Model model){
		
		
		return "contact";
	}
	
	@RequestMapping("pricing")
	public String pricing(Model model){
		
		
		return "pricing";
	}
	
	@RequestMapping("promotions")
	public String promotions(Model model){
		
		
		return "promotions";
	}
	
	@RequestMapping("tournaments")
	public String tournaments(Model model){
		
		
		return "tournaments";
	}
		
}
