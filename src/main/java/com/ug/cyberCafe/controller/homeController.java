package com.ug.cyberCafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class homeController {

	@RequestMapping("/home")
	public String welcome(Model model){
		model.addAttribute("greeting", "Witaj Świecie!!");
		model.addAttribute("tagline", "Pierwsze kroki z springMVC");
		
		return "home";
	}
		
}
