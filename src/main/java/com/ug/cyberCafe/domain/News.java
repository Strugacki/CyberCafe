package com.ug.cyberCafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="NEWS")
@NamedQueries({ 
	@NamedQuery(name = "get.All.News", query = "Select n from News n"),
	@NamedQuery(name = "get.User.By.News.Id", query = "SELECT u.nickname FROM User u")
})
@Data
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

}
