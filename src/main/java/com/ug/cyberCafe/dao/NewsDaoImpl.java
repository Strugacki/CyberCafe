package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ug.cyberCafe.domain.Address;
import com.ug.cyberCafe.domain.News;

public class NewsDaoImpl extends AbstractDao<Integer, News> implements NewsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addNews(News news) {
		sessionFactory.getCurrentSession().save(news);
	}

	@Override
	public void deleteNews(News news) {
		news = (News) sessionFactory.getCurrentSession().get(News.class, news.getIdNews());
		sessionFactory.getCurrentSession().delete(news);
		
	}

	@Override
	public List<News> getAllNews() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.News").list();
	}

	@Override
	public News getNewsById(long id) {
		return (News) sessionFactory.getCurrentSession().get(News.class, id);
	}

	@Override
	public void updateNews(News news) {
		News newsToUpdate = getNewsById(news.getIdNews());
		newsToUpdate.setBody(news.getBody());
		newsToUpdate.setUploadDate(news.getUploadDate());
		newsToUpdate.setUsers(news.getUsers());
		sessionFactory.getCurrentSession().update(newsToUpdate);
	}

}
