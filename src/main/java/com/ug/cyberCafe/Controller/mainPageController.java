package com.ug.cyberCafe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class mainPageController {

	@RequestMapping("/")
	public String welcome(Model model){
		
		return null;
	}
	
}
