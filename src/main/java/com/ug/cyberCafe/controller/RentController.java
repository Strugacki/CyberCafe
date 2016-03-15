package com.ug.cyberCafe.controller;


import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ug.cyberCafe.domain.Rent;
import com.ug.cyberCafe.domain.Terminal;
import com.ug.cyberCafe.domain.User;
import com.ug.cyberCafe.service.RentService;
import com.ug.cyberCafe.service.TerminalService;
import com.ug.cyberCafe.service.UserService;

@Controller
@RequestMapping("/rent")
public class RentController {
	
	final static Logger LOGGER = Logger.getLogger(RentController.class);
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TerminalService terminalService;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.registerCustomEditor(Terminal.class,"terminal", new PropertyEditorSupport() {
					
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Terminal terminal = terminalService.getTerminalById(Long.parseLong(text));
				this.setValue(terminal);
				
			}
			
		});
		
		PropertyEditorSupport customerSupport = new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				//User user = userService.getUserById(Long.parseLong(text));
				this.setValue(userService.getUserById(Long.parseLong(text)));
				
			}
		};
		
		PropertyEditorSupport employeeSupport = new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				//User user = userService.getUserById(Long.parseLong(text));
				this.setValue(userService.getUserById(Long.parseLong(text)));
				
			}
		};
		
		binder.registerCustomEditor(User.class,"customer", customerSupport);
		binder.registerCustomEditor(User.class,"employee", employeeSupport);
	
		
	}
	
	@RequestMapping(value = "list")
	public String list(Model model){
		authorization(model);
		model.addAttribute("rents",rentService.getAllRents());
		return "/rent/listRent";
	}
	
	@RequestMapping(value = "search", method=RequestMethod.GET)
	public @ResponseBody String reservationCheck(@Valid @RequestParam("idTerminal") String idTerminal, @RequestParam("date") String date){
		Long idTerminall = Long.parseLong(idTerminal);
		String datee = date;
		List<Rent> dbResults = new ArrayList<Rent>();
		dbResults = rentService.getRentByIdTerminal(idTerminall, datee);
		LOGGER.info(dbResults);
		String response = "";
		for(int i=10;i<23;i++){
			if(dbResults.size()>0){
				for(int j=0;j<dbResults.size();j++){
					if(i == dbResults.get(j).getTimeStart()){
						int calcError=dbResults.get(j).getHours();
						i=i+calcError;
					}
				}
				response+="<option class='optionHours' value='"+i+"'>"+i+":00</option>"  ;
			}else{
				response+="<option class='optionHours' value='"+i+"'>"+i+":00</option>"  ;
			}
		}
		return response;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String getAddRentForm(Model model){
		authorization(model);
		Rent newRent = new Rent();
		User employee = userService.getUserByUsername(getPrincipal());
		model.addAttribute("newRent",newRent);
		model.addAttribute("idEmployee",employee.getIdUser());
		model.addAttribute("customers", userService.getUsersByRole("ROLE_USER"));
		model.addAttribute("terminals",terminalService.getAllAvailableTerminals());
		return "/rent/addRent";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddRentForm(@ModelAttribute("newRent") Rent newRent, BindingResult rentResult, Model model){
		authorization(model);
		if(rentResult.hasErrors()){
			model.addAttribute("warn","Nie udało się dodać wypożyczenia, spróbuj ponownie!");
			
			LOGGER.info(rentResult);
			return "rent/addRent";
		}else{
			rentService.addRent(newRent);
		}
		return "redirect: /rent/list";
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
	
	private Model authorization(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( !(auth instanceof AnonymousAuthenticationToken)){
			model.addAttribute("user",getPrincipal());
			if(auth.getAuthorities() != null){
				for(GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
					String role = authority.getAuthority();
					LOGGER.info(role);
					model.addAttribute("role",role);
				}
			}
		}else{
			model.addAttribute("user", null);
		}
		
		return model;
	}

}
