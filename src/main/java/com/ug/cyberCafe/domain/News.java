package com.ug.cyberCafe.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NEWS")
@NamedQueries({ 
	@NamedQuery(name = "get.All.News", query = "Select n from News n"),
})
public class News {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idNews;
	
	@Column(name = "BODY", nullable = true)
	private String body;
	
	@Column(name = "UPLOADDATE", nullable = false)
	private String uploadDate;
	
	@OneToMany
	private Set<User> users;
	
	public News(){
		
	}
	
	public News(String body, String uploadDate) {
		super();
		this.setBody(body);
		this.setUploadDate(uploadDate);
	}
	
	public long getIdNews() {
		return idNews;
	}

	public void setIdNews(long idNews) {
		this.idNews = idNews;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
