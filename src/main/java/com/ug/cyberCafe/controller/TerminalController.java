package com.ug.cyberCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ug.cyberCafe.service.TerminalService;
import com.ug.cyberCafe.domain.Terminal;



@Controller
@RequestMapping("/device")
public class TerminalController {

	    @Autowired
		private TerminalService terminalService;
		
	    
	    @RequestMapping
	    public  String list(Model model){
	    	
	    	model.addAttribute("products",terminalService.getAllTerminals());
	    	
	    	return "devices";
	    }
		/**
		 * 
		 */
		@RequestMapping(value ="add", method = RequestMethod.GET)
		public String getAddNewTerminalForm(Model model){
			Terminal newTerminal = new Terminal();
			Authorization(model);
			model.addAttribute("newTerminal", newTerminal);
			return "terminal/addTerminal";
		}
		
		/**
		 * 
		 */
		@RequestMapping(value="add", method = RequestMethod.POST)
		public String processAddNewTerminalForm(@ModelAttribute("newTerminal") Terminal newTerminal){
			terminalService.addTerminal(newTerminal);
			return "redirect:/" ;
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
						System.out.println(role);
						model.addAttribute("role",role);
					}
				}
			}else{
				model.addAttribute("user", null);
			}
			
			return model;
		}
	
	
	
}
