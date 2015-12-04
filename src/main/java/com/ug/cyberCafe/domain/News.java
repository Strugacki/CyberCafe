package com.ug.cyberCafe.domain;

import java.sql.Blob;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class News {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_news;
	
	private String body;
	private String uploadDate;
	
}
