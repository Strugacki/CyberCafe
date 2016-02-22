package com.ug.cyberCafe.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
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
	@Autowired
	private NewsService newsService;
	private HashMap<String, ArrayList> menu = new HashMap<String, ArrayList>();
	
	public HashMap<String, ArrayList> fillMenu(String who){
		
		ArrayList<String> user = new ArrayList();
		
		user.add("/user/add");
		user.add("/user/delete");
		user.add("/user/update");
		user.add("/user/list");
		
		menu.put("user", user);
		return menu;
	}
	
	@RequestMapping
	public String welcome(Model model){
		if(!newsService.getAllNews().isEmpty()){
			model.addAttribute("news",newsService.getAllNews());
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( !(auth.getPrincipal() instanceof AnonymousAuthenticationToken)){
			model.addAttribute("user",getPrincipal());
			System.out.println(auth.getPrincipal().toString());
		}else{
			model.addAttribute("user", null);
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
		
}
