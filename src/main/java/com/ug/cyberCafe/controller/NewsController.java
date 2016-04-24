package com.ug.cyberCafe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

import com.ug.cyberCafe.domain.News;
import com.ug.cyberCafe.domain.User;
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

	/**
	 * Show all news controller method
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list")
	public String list(Model model){
		newsService.authorization(model);
		model.addAttribute("news", newsService.getAllNews());
		
		return "news/listNews";
	}
	
	/**
	 * Get news add form controller method
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String getAddNewsForm(Model model) {
		newsService.authorization(model);
		News newNews = News.builder().build();
		model.addAttribute("newNews",newNews);
		return "news/addNews";
	}
	
	/**
	 * Process news add form controller method
	 * @param newNews
	 * @param resultNews
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddNewsForm(@Valid @ModelAttribute("newNews") News newNews, BindingResult resultNews, Model model){
		newsService.authorization(model);
		if(resultNews.hasErrors()){
			model.addAttribute("warn","Nie udało się dodać newsa, spróbuj ponownie!");
			LOGGER.info("news result: " + resultNews.toString());
			return "news/addNews";
		}else{
			String uploadDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			LOGGER.info("upload date: "+uploadDate);
			User user = userService.getUserByUsername(newsService.getPrincipal());
			newNews.setUploadDate(uploadDate);
			newNews.setUser(user);
			newsService.addNews(newNews);
			
			return "redirect:/news/list";
		}
	}
	
	/**
	 * Get news update form controller method
	 * @param idNews
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/update", method = RequestMethod.GET)
	public String getUpdateNewsForm(@RequestParam("id") String idNews,Model model){
		newsService.authorization(model);
		News newsToUpdate = newsService.getNewsById(Long.parseLong(idNews));
		model.addAttribute("newsToUpdate", newsToUpdate);
		
		return "news/updateNews";
	}
	
	/**
	 * Process news update form controller method
	 * @param newsToUpdate
	 * @param resultNews
	 * @param idNews
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/update", method = RequestMethod.POST)
	public String processUpdateNewsForm(@Valid @ModelAttribute("newsToUpdate") News newsToUpdate, BindingResult resultNews, @RequestParam("id") String idNews,Model model){
		newsService.authorization(model);
		if(resultNews.hasErrors()){
			model.addAttribute("warn","Nie udało się wykonać aktualizacji newsa, spróbuj ponownie!");
			LOGGER.info("result news: "+resultNews.toString());
			return "news/updateNews";
		}else{
			newsService.updateNews(newsToUpdate);
			return "redirect:/news/list";
		}
		
	}
	
	/**
	 * Delete news controller method
	 * @param idNews
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteTerminal(@RequestParam("id") String idNews, Model model) {
		newsService.authorization(model);
		News newsToDelete = newsService.getNewsById(Long.parseLong(idNews));
		newsService.deleteNews(newsToDelete);
		return "redirect:/";
	}
}
