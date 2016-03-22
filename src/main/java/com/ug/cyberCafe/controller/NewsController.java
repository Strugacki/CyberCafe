package com.ug.cyberCafe.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ug.cyberCafe.domain.News;
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
		newsService.authorization(model);

		return "news/addNews";
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteTerminal(@RequestParam("id") String idNews, Model model) {
		newsService.authorization(model);
		News newsToDelete = newsService.getNewsById(Long.parseLong(idNews));
		newsService.deleteNews(newsToDelete);
		return "redirect:/";
	}
}
