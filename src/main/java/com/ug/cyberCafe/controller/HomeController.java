package com.ug.cyberCafe.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ug.cyberCafe.service.NewsService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping
	public String welcome(Model model){
		model.addAttribute("news",newsService.getAllNews());
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
