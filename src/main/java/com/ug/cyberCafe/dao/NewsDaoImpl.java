package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.domain.News;
import com.ug.cyberCafe.domain.User;

@Component("newsDao")
public class NewsDaoImpl implements NewsDao {

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
		sessionFactory.getCurrentSession().update(news);
	}

	@Override
	@Transactional
	public void deleteAllNews() {
		for(News news : getAllNews() ) {
			deleteNews(news);
		}
	}

	@Override
	public User getUserByNewsId(long id) {
		try{
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			User user = null;
			Query query = sessionFactory.getCurrentSession().getNamedQuery("get.User.By.News.Id");
			query.setLong(0, id);
			List<User> results = query.list();
			if (!results.isEmpty()) {
				user = results.get(0);
			}
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
