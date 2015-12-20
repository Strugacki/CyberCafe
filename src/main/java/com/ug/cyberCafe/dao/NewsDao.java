package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.News;

public interface NewsDao {
	
    void addNews(News news);
    
    void deleteNewsById(int id);
     
    List<News> getAllNews();
 
    News getNewsById(int id);

}
