package com.ug.cyberCafe.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ug.cyberCafe.domain.User;
import com.ug.cyberCafe.service.NewsService;


@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private NewsService newsService;
	private HashMap<String, String> menu = new HashMap<String, String>();
	
	public HashMap<String, String> fillMenu(HttpSession session){
		
		menu.put("/about", "O nas");
		menu.put("/contact", "Kontakt");
		menu.put("/pricing", "Cennik");
		menu.put("/promotions", "Promocje");
		menu.put("/devices", "Sprzęt");
		menu.put("/events", "Trniejeu");
		
		if(session.getAttribute("user") != null){
			User user = (User) session.getAttribute("user");
			menu.put("/user/profile/?id="+ user.getIdUser(), "Konto");
		}
		
		return menu;
	}
	
	@RequestMapping
	public String welcome(Model model){
		if(!newsService.getAllNews().isEmpty()){
			model.addAttribute("news",newsService.getAllNews());
		}
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
	
	@RequestMapping("events")
	public String tournaments(Model model){
		
		
		return "events";
	}
		
}
