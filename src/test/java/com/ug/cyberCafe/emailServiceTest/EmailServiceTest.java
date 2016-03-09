package com.ug.cyberCafe.emailServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ug.cyberCafe.service.email.EmailService;

@ContextConfiguration(locations = { "classpath:/mail-context-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailServiceTest {

	@Autowired
	EmailService emailService;
	
	@Test
	public void sendMailCheck() {
		
		String body = "Test body";
		String subject = "Test subject";
		String from = "dajminazwe@gmail.com";
		String to = "dajminazwe@gmail.com";
		emailService.sendEmail(to, from, subject, body);
	}

}
