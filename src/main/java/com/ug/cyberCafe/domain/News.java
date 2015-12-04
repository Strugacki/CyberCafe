package com.ug.cyberCafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TERMINAL")
public class News {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_news;
	
	@Column(name = "BODY", nullable = true)
	private String body;
	
	@Column(name = "UPLOADDATE", nullable = false)
	private String uploadDate;
	
	public News(){
		
	}
	
	public News(String body, String uploadDate) {
		super();
		this.setBody(body);
		this.setUploadDate(uploadDate);
	}
	
	public long getId_news() {
		return id_news;
	}

	public void setId_news(long id_news) {
		this.id_news = id_news;
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
}
