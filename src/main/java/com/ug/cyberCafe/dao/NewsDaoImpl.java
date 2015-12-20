package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ug.cyberCafe.domain.News;

public class NewsDaoImpl extends AbstractDao<Integer, News> implements NewsDao {

	@Override
	public void addNews(News news) {
		persist(news);
	}

	@Override
	public void deleteNewsById(int id) {
		
		
	}

	@Override
	public List<News> getAllNews() {
		Criteria criteria = createEntityCriteria();
        return (List<News>) criteria.list();
	}

	@Override
	public News getNewsById(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (News) criteria.uniqueResult();
	}

}
