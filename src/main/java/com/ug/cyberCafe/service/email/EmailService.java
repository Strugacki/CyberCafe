package com.ug.cyberCafe.service.email;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.mail.MailSender;
	import org.springframework.mail.SimpleMailMessage;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	 
	@Service("email")
	@Transactional
	public class EmailService {
	 
		@Autowired
		private MailSender email;
		
		public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
	 
			SimpleMailMessage emailMsg = new SimpleMailMessage();
			emailMsg.setFrom(fromAddress);
			emailMsg.setTo(toAddress);
			emailMsg.setSubject(subject);
			emailMsg.setText(msgBody);
			email.send(emailMsg);
		}
	}
