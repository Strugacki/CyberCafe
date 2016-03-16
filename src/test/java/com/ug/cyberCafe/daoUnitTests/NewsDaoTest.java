package com.ug.cyberCafe.daoUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.NewsDao;
import com.ug.cyberCafe.dao.UserDao;
import com.ug.cyberCafe.domain.Address;
import com.ug.cyberCafe.domain.News;
import com.ug.cyberCafe.domain.User;

@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional("transactionManager")
public class NewsDaoTest {

	@Autowired
	NewsDao newsDao;
	
	@Autowired
	UserDao userDao;
	
	//global
	private List<User> allUsers;
	
	//for user
	private String FIRSTNAME = "John";
	private String LASTNAME = "Smith";
	private String EMAIL = "test@email.com";
	private Boolean ACTIVE = true;
	private String DATEOFBIRTH = "1994-04-10";
	private String NICKNAME = "Andriej";
	private String LOGIN = "qwerty";
	private String PASSWORD = "123456";
	
	//for news
	private String BODY = "This is testing body";
	private String UPLOADDATE = "1922-12-12";
	
	/*Initialization method that cleares the news table from database and add few records before starting test method*/
	@Before public void initialize() {
		newsDao.deleteAllNews();
		userDao.deleteAllUsers();
		
		User userToAdd = new User();
		userToAdd.setFirstName(FIRSTNAME);
		userToAdd.setLastName(LASTNAME);
		userToAdd.setEmail(EMAIL);
		userToAdd.setActive(ACTIVE);
		userToAdd.setDateOfBirth(DATEOFBIRTH);
		userToAdd.setNickname(NICKNAME);
		userToAdd.setLogin(LOGIN);
		userToAdd.setPassword(PASSWORD);
		userDao.addUser(userToAdd);
		
		allUsers = userDao.getAllUsers();
		
		/*First address added*/
		News newsToAdd = new News();
		newsToAdd.setBody(BODY);
		newsToAdd.setUploadDate(UPLOADDATE);
		newsToAdd.setUser(allUsers.get(0));
		newsDao.addNews(newsToAdd);
		
		/*Second address added*/
		News newsToAdd2 = new News();
		newsToAdd2.setBody(BODY);
		newsToAdd2.setUploadDate(UPLOADDATE);
		newsToAdd2.setUser(allUsers.get(0));
		newsDao.addNews(newsToAdd2);
	}
	
	/*Finishing method that cleares the address table from database*/
	@After public void finishing() {
		newsDao.deleteAllNews();
	}
	
	@Test
	public void addNewsCheck() {
			
		List<News> retrievedNews = newsDao.getAllNews();
		assertEquals(BODY,retrievedNews.get(0).getBody());
		assertEquals(UPLOADDATE,retrievedNews.get(0).getUploadDate());
		assertEquals(FIRSTNAME,retrievedNews.get(0).getUser().getFirstName());
	}
	
	@Test
	public void getAllNewsCheck() {
		List<News> retrievedNews = newsDao.getAllNews();
		assertEquals(2, retrievedNews.size());
	}
	
	@Test
	public void deleteAllNewsCheck() {
		List<News> retrievedNews = newsDao.getAllNews();
		assertNotNull(retrievedNews);
		newsDao.deleteAllNews();
		List<News> retrievedNewsAfterDelete = newsDao.getAllNews();
		assertEquals(retrievedNewsAfterDelete, new ArrayList<>(0));
	}
	
	@Test 
	public void updateNewsCheck() {
		List<News> retrievedNews = newsDao.getAllNews();
		News newsToUpdate = retrievedNews.get(0);
		newsToUpdate.setBody("Something else");
		newsToUpdate.setUploadDate("2010-01-10");
		newsDao.updateNews(newsToUpdate);
		
		List<News> retrievedNewsAfterUpdate = newsDao.getAllNews();
		assertEquals("Something else",retrievedNewsAfterUpdate.get(0).getBody());
		assertEquals("2010-01-10", retrievedNewsAfterUpdate.get(0).getUploadDate());
	}
	
	@Test
	public void getNewsByIdCheck() {
		List<News> retrievedNews = newsDao.getAllNews();
		News newsToCompare = retrievedNews.get(0);
		Long idToCompare = retrievedNews.get(0).getIdNews();
		News newsToCompare2 = newsDao.getNewsById(idToCompare);
		assertEquals(newsToCompare,newsToCompare2);
	}
}
