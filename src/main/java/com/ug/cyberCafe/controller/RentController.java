package com.ug.cyberCafe.controller;


import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
		rentService.authorization(model);
		model.addAttribute("rents",rentService.getAllRents());
		return "/rent/listRent";
	}
	
	@RequestMapping(value = "search", method=RequestMethod.GET)
	public @ResponseBody String reservationCheck(@Valid @RequestParam("idTerminal") String idTerminal, @RequestParam("date") String date){
		Long idTerminall = Long.parseLong(idTerminal);
		String datee = date;
		List<Rent> dbResults = new ArrayList<Rent>();
		dbResults = rentService.getRentByIdTerminal(idTerminall, datee);
		LOGGER.info("getRentByIdTerminal - db results: " + dbResults);
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
		rentService.authorization(model);
		Rent newRent = Rent.builder().build();
		User employee = userService.getUserByUsername(rentService.getPrincipal());
		model.addAttribute("newRent",newRent);
		model.addAttribute("idEmployee",employee.getIdUser());
		model.addAttribute("customers", userService.getUsersByRole("ROLE_USER"));
		model.addAttribute("terminals",terminalService.getAllAvailableTerminals());
		return "/rent/addRent";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddRentForm(@ModelAttribute("newRent") Rent newRent, BindingResult rentResult, Model model){
		rentService.authorization(model);
		if(rentResult.hasErrors()){
			model.addAttribute("warn","Nie udało się dodać wypożyczenia, spróbuj ponownie!");
			LOGGER.info("rentResult: "+rentResult);
			return "rent/addRent";
		}else{
			LOGGER.info("Rent time start: " + newRent.getTimeStart() + " rent Hours: " + newRent.getHours() + " rent price: " + newRent.getPrice());
			return "redirect:/rent/list";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") String idRent, Model model){
		rentService.authorization(model);
		rentService.deleteRent(rentService.getRentById(Long.parseLong(idRent)));
		return "redirect:/rent/list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String getUpdateRentForm(@RequestParam("id") String idRent, Model model){
		rentService.authorization(model);
		Rent rentToUpdate = rentService.getRentById(Long.parseLong(idRent));
		LOGGER.info("Rent to update - terminal type: " + rentToUpdate.getTerminal().getType());
		model.addAttribute("customers", userService.getUsersByRole("ROLE_USER"));
		model.addAttribute("terminals",terminalService.getAllAvailableTerminals());
		model.addAttribute("rentToUpdate", rentToUpdate);
		return "rent/updateRent";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String processUpdateRentForm(@RequestParam("id") String idRent, @ModelAttribute("rentToUpdate") Rent rentToUpdate, BindingResult rentResult, Model model){
		rentService.authorization(model);
		if(rentResult.hasErrors()){
			model.addAttribute("warn","Nie udało się wykonać aktualizacji wypożyczenia, spróbuj ponownie!");
			LOGGER.info("rent result: " + rentResult);			
			return "rent/updateRent";
		}else{
			rentService.updateRent(rentToUpdate);
			return "redirect:/rent/list";
		}
	}

}
