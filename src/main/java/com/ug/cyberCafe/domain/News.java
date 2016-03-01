package com.ug.cyberCafe.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NEWS")
@NamedQueries({ 
	@NamedQuery(name = "get.All.News", query = "Select n from News n"),
	@NamedQuery(name = "get.User.By.News.Id", query = "SELECT u.nickname FROM User u, News n ON u.idUser=n.user and n.idNews = ?")
})
public class News {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNEWS", nullable = false)
	private long idNews;
	
	@Column(name = "TITLE", nullable = false)
	private String title;

	@Column(name = "BODY", nullable = true)
	private String body;
	
	@Column(name = "UPLOADDATE", nullable = false)
	private String uploadDate;
	
	@ManyToOne
	@JoinColumn(name="USER_IDUSER")
	private User user;
	
	public News(){
		
	}
	//, News n WHERE (u.idUser=r.user.idUser) AND (n.idNews= ?)
	public News(String title, String body, String uploadDate) {
		super();
		this.setTitle(title);
		this.setBody(body);
		this.setUploadDate(uploadDate);
	}
	
	public long getIdNews() {
		return idNews;
	}

	public void setIdNews(long idNews) {
		this.idNews = idNews;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public User getUsers() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}
	
	
}
