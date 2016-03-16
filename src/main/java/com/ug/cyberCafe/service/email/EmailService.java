package com.ug.cyberCafe.service.email;

	import org.springframework.mail.MailSender;
	import org.springframework.mail.SimpleMailMessage;
	 
	//@Service("email")
	public class EmailService {
	 
		//@Autowired
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
