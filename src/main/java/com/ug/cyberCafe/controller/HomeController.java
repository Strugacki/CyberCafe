package com.ug.cyberCafe.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String redirect(){
		return "redirect:/home";
	}
	
	/**
	 * Controller method rendering home page
	 * @param model
	 * @return
	 */
	@RequestMapping("home")
	public String welcome(Model model){
		newsService.authorization(model);
		if(!newsService.getAllNews().isEmpty()){
			model.addAttribute("news",newsService.getAllNews());
		}
		
		return "home";
	}
	
	/**
	 * Controller method rendering about page
	 * @param model
	 * @return
	 */
	@RequestMapping("about")
	public String about(Model model){
		newsService.authorization(model);
		
		return "about";
	}
	
	/**
	 * Controller method rendering contact page
	 * @param model
	 * @return
	 */
	@RequestMapping("contact")
	public String contact(Model model){
		newsService.authorization(model);
		
		return "contact";
	}
	
	/**
	 * Controller method rendering pricing page
	 * @param model
	 * @return
	 */
	@RequestMapping("pricing")
	public String pricing(Model model){
		newsService.authorization(model);
		
		return "pricing";
	}
	
	/**
	 * Controller method rendering promotions page
	 * @param model
	 * @return
	 */
	@RequestMapping("promotions")
	public String promotions(Model model){
		newsService.authorization(model);
		
		return "promotions";
	}
	
	/**
	 * Controller method rendering tournaments page
	 * @param model
	 * @return
	 */
	@RequestMapping("events")
	public String tournaments(Model model){
		newsService.authorization(model);
		
		return "events";
	}
}
