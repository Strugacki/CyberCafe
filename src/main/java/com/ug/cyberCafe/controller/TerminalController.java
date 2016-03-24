package com.ug.cyberCafe.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
		terminalService.authorization(model);
		model.addAttribute("terminals", terminalService.getAllTerminals());
		return "terminal/listTerminal";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String getAddNewTerminalForm(Model model) {
		terminalService.authorization(model);
		Terminal newTerminal = Terminal.builder().build();
		model.addAttribute("newTerminal", newTerminal);
		return "terminal/addTerminal";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddNewTerminalForm(@Valid @ModelAttribute("newTerminal") Terminal newTerminal,BindingResult result, Model model) {
		terminalService.authorization(model);
		if (result.hasErrors()) {
			model.addAttribute("warn", "Nie udało się dodać terminalu, spróbuj ponownie!");
			return "terminal/addTerminal";
		} else {
			terminalService.addTerminal(newTerminal);
			return "redirect:/device/list";
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteTerminal(@RequestParam("id") String idTerminal, Model model) {
		terminalService.authorization(model);
		Terminal terminalToDelete = terminalService.getTerminalById(Long.parseLong(idTerminal));
		terminalService.deleteTerminal(terminalToDelete);
		return "redirect:/device/list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String getUpdateTerminalForm(@RequestParam("id") String idTerminal, Model model) {
		terminalService.authorization(model);
		Terminal terminalToUpdate = terminalService.getTerminalById(Long.parseLong(idTerminal));
		model.addAttribute("terminalToUpdate", terminalToUpdate);
		return "terminal/updateTerminal";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String processUpdateTerminalForm(@Valid @ModelAttribute("terminal") Terminal terminalToUpdate,@RequestParam("id") String idTerminal, BindingResult result, Model model) {
		terminalService.authorization(model);
		if (result.hasErrors()) {
			model.addAttribute("warn", "Nie udało się wykonać aktualizacji, spróbuj ponownie!");
			return "terminal/updateTerminal";
		} else {
			terminalService.updateTerminal(terminalToUpdate);
			return "redirect:/device/list";
		}
	}

}
