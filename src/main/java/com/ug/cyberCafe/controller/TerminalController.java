package com.ug.cyberCafe.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ug.cyberCafe.service.TerminalService;
import com.ug.cyberCafe.domain.Terminal;

@Controller
@RequestMapping("/device")
public class TerminalController {

	final static Logger LOGGER = Logger.getLogger(TerminalController.class);

	@Autowired
	private TerminalService terminalService;

	@RequestMapping("list")
	public String list(Model model) {
		Authorization(model);
		model.addAttribute("terminals", terminalService.getAllTerminals());
		return "terminal/listTerminal";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String getAddNewTerminalForm(Model model) {
		Terminal newTerminal = new Terminal();
		Authorization(model);
		model.addAttribute("newTerminal", newTerminal);
		return "terminal/addTerminal";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddNewTerminalForm(@Valid @ModelAttribute("newTerminal") Terminal newTerminal,
			BindingResult result, Model model) {
		Authorization(model);
		if (result.hasErrors()) {
			model.addAttribute("warn", "Nie udało się dodać terminalu, spróbuj ponownie!");
			return "terminal/addTerminal";
		} else {
			Authorization(model);
			terminalService.addTerminal(newTerminal);
			return "redirect:/device/list";
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteTerminal(@RequestParam("id") String idTerminal, Model model) {
		Authorization(model);
		Terminal terminalToDelete = terminalService.getTerminalById(Long.parseLong(idTerminal));
		terminalService.deleteTerminal(terminalToDelete);
		return "redirect:/device/list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String getUpdateTerminalForm(@RequestParam("id") String idTerminal, Model model) {
		Authorization(model);
		Terminal terminalToUpdate = terminalService.getTerminalById(Long.parseLong(idTerminal));
		model.addAttribute("terminalToUpdate", terminalToUpdate);
		return "terminal/updateTerminal";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String processUpdateTerminalForm(@Valid @ModelAttribute("terminal") Terminal terminalToUpdate,
			@RequestParam("id") String idTerminal, BindingResult result, Model model) {
		Authorization(model);
		if (result.hasErrors()) {
			model.addAttribute("warn", "Nie udało się wykonać aktualizacji, spróbuj ponownie!");
			return "terminal/updateTerminal";
		} else {
			terminalService.updateTerminal(terminalToUpdate);
			return "redirect:/device/list";
		}
	}

	/**
	 * 
	 * @return
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * Method setting user attribute and setting appriopriate role attribute to
	 * model
	 * 
	 * @param model
	 * @return model
	 */
	private Model Authorization(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			model.addAttribute("user", getPrincipal());
			if (auth.getAuthorities() != null) {
				for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication()
						.getAuthorities()) {
					String role = authority.getAuthority();
					LOGGER.info(role);
					model.addAttribute("role", role);
				}
			}
		} else {
			model.addAttribute("user", null);
		}

		return model;
	}

}
