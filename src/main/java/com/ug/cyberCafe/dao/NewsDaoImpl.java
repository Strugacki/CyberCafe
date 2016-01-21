package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.domain.News;

@Component("newsDao")
public class NewsDaoImpl extends AbstractDao<Integer, News> implements NewsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addNews(News news) {
		sessionFactory.getCurrentSession().save(news);
	}

	@Override
	@Transactional
	public void deleteNews(News news) {
		news = (News) sessionFactory.getCurrentSession().get(News.class, news.getIdNews());
		sessionFactory.getCurrentSession().delete(news);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<News> getAllNews() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.News").list();
	}

	@Override
	@Transactional
	public News getNewsById(long id) {
		return (News) sessionFactory.getCurrentSession().get(News.class, id);
	}

	@Override
	@Transactional
	public void updateNews(News news) {
		News newsToUpdate = getNewsById(news.getIdNews());
		newsToUpdate.setBody(news.getBody());
		newsToUpdate.setUploadDate(news.getUploadDate());
		newsToUpdate.setUsers(news.getUsers());
		sessionFactory.getCurrentSession().update(newsToUpdate);
	}

	@Override
	public void deleteAllNews() {
		for(News news : getAllNews() ) {
			deleteNews(news);
		}
	}

}
