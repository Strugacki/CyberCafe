package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.NewsDao;
import com.ug.cyberCafe.domain.News;

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NewsDao newsDao;

	@Override
	public News getNewsById(long id) {
		return newsDao.getNewsById(id);
	}

	@Override
	public void addNews(News news) {
		newsDao.addNews(news);
	}

	@Override
	public void updateNews(News news) {
		
	}

	@Override
	public void deleteNews(News news) {
		newsDao.deleteNews(news);
	}

	@Override
	public List<News> getAllNews() {
		return newsDao.getAllNews();
	}

}
