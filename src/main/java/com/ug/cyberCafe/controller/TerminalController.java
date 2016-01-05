package com.ug.cyberCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ug.cyberCafe.dao.TerminalDao;
import com.ug.cyberCafe.domain.Terminal;



@Controller
@RequestMapping("/devices")
public class TerminalController {

	    //@Autowired
		//private TerminalDao TerminalDao;
		
	    
	    @RequestMapping
	    public  String list(Model model){
	    	
	    	//model.addAttribute("products",TerminalDao.getAllTerminals());
	    	
	    	return "devices";
	    }
		/**
		 * 
		 */
		@RequestMapping(method = RequestMethod.GET)
		public String getAddNewTerminalForm(Model model){
			Terminal newTerminal = new Terminal();
			model.addAttribute("newTerminal", newTerminal);
			return "devices";
		}
		
		/**
		 * 
		 */
		@RequestMapping(method = RequestMethod.POST)
		public String processAddNewTerminalForm(@ModelAttribute("newTerminal") Terminal newTerminal){
			//TerminalDao.addTerminal(newTerminal);
			return "redirect:/devices" ;
		}
	
	
	
}
