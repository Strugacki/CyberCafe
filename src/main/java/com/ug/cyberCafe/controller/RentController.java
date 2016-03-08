package com.ug.cyberCafe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ug.cyberCafe.domain.Rent;
import com.ug.cyberCafe.service.RentService;
import com.ug.cyberCafe.service.TerminalService;
import com.ug.cyberCafe.service.UserService;

@Controller
@RequestMapping("/rent")
public class RentController {
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TerminalService terminalService;
	
	
	@RequestMapping(value = "list")
	public String list(Model model){
		authorization(model);
		model.addAttribute("rents",rentService.getAllRents());
		return "/rent/listRent";
	}
	
	@RequestMapping(value = "search", method=RequestMethod.GET)
	public @ResponseBody String reservationCheck(@RequestParam("idTerminal") String idTerminal, @RequestParam("date") String date){
		Long idTerminall = Long.parseLong(idTerminal);
		String datee = date;
		List<Rent> dbResults = new ArrayList<Rent>();
		dbResults = rentService.getRentByIdTerminal(idTerminall, datee);
		System.out.println(dbResults);
		String response = "";
		for(int i=10;i<23;i++){
			if(dbResults.size()>0){
				for(int j=0;j<dbResults.size();j++){
					if((i<dbResults.get(j).getTimeStart() && i<=dbResults.get(j).getTimeEnd()) || (i>=dbResults.get(j).getTimeStart() && i>dbResults.get(j).getTimeEnd())){
						response+="<li><label>"+i+":00 <input id='"+i+"' type='radio' name='hour' value='"+i+"' /></label></li>";
					}
				}
			}else{
				response+="<li><label>"+i+":00 <input id='"+i+"' type='radio' name='hour' value='"+i+"' /></label></li>";
			}
		}
		return response;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String getAddRentForm(Model model){
		authorization(model);
		Rent newRent = new Rent();
		model.addAttribute("newRent",newRent);
		model.addAttribute("customers", userService.getUsersByRole("ROLE_USER"));
		model.addAttribute("terminals",terminalService.getAllAvailableTerminals());
		return "/rent/addRent";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddRentForm(@ModelAttribute("newRent") Rent newRent, BindingResult rentResult, Model model){
		authorization(model);
		
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
