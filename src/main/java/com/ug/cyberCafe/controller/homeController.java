package com.ug.cyberCafe.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class homeController {
	ArrayList<String> menu = new ArrayList<String>();
	
	@RequestMapping("/")
	public String welcome(Model model){
		model.addAttribute("greeting", "Witaj na stronie naszej Kawiarenki Internetowej!!");
		model.addAttribute("tagline", "Jedyne takie miejsce w Trójmieście");
		
		return "home";
	}
		
}
