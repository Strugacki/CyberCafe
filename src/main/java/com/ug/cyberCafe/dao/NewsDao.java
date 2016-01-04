package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.News;

public interface NewsDao {
	
    void addNews(News news);
    
    void deleteNews(News news);
     
    List<News> getAllNews();
 
    News getNewsById(long id);
    
    void updateNews(News news);
}
