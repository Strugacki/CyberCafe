package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ug.cyberCafe.domain.News;
import com.ug.cyberCafe.domain.User;

public interface NewsService {

	News getNewsById(long id);

	void addNews(News news);

	void updateNews(News news);

	void deleteNews(News news);

	List<News> getAllNews();
	
	User getUserByNewsId(long id);
	
	String getPrincipal();
	
	Model authorization(Model model);
}
