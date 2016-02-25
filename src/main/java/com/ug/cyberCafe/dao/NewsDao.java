package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.News;
import com.ug.cyberCafe.domain.User;

public interface NewsDao {
	
    void addNews(News news);
    
    void deleteNews(News news);
     
    List<News> getAllNews();
 
    News getNewsById(long id);
    
    void updateNews(News news);

	void deleteAllNews();
	
	User getUserByNewsId(long id);
}
