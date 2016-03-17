package com.ug.cyberCafe.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ug.cyberCafe.domain.News;
import com.ug.cyberCafe.domain.Terminal;
import com.ug.cyberCafe.service.NewsService;
import com.ug.cyberCafe.service.UserService;

@Controller
@RequestMapping("/news")
public class NewsController {

	final static Logger LOGGER = Logger.getLogger(NewsController.class);

	@Autowired
	UserService userService;

	@Autowired
	NewsService newsService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String getAddNewsForm(Model model) {
		Authorization(model);

		return "news/addNews";
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteTerminal(@RequestParam("id") String idNews, Model model) {
		Authorization(model);
		News newsToDelete = newsService.getNewsById(Long.parseLong(idNews));
		newsService.deleteNews(newsToDelete);
		return "redirect:/";
	}
	

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
