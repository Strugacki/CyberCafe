package com.ug.cyberCafe.service;

import java.util.List;

import com.ug.cyberCafe.domain.News;

public interface NewsService {

	News getNewsById(long id);

	void addNews(News news);

	void updateNews(News news);

	void deleteNews(News news);

	List<News> getAllNews();
}
