package com.email.trigger.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.email.trigger.to.Emailto;

@Service
public class EmailService {
	
	public boolean sendEmail(Emailto emailTo) {
		
		boolean status = false;
		String from = "shivanisikati@gmail.com";
		
		//variable for gmail
		String host = "smtp.gmail.com";
		
		//get system properties 
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		//set host 
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		//step1: to get session object 
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("shivanisikati@gmail.com","zmrgbfsekroedlnc");
			}
		});
		
		session.setDebug(true);
	
		//step2:Compose message to text(text,multi media)
		MimeMessage msg = new MimeMessage(session);
		
		try {
			
			//from email
			msg.setFrom();
			
			//set receipt
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo.getTo()));
			msg.setRecipient(Message.RecipientType.CC, new InternetAddress(emailTo.getCc()));
			
			//addnig subject 
			msg.setSubject(emailTo.getSubject());
			
			//attachment 
			MimeMultipart mimemultipart = new MimeMultipart();
			
			//text 
			MimeBodyPart mimetextpart = new MimeBodyPart();
			
			try {
				
				mimetextpart.setText(emailTo.getText());
				
				mimemultipart.addBodyPart(mimetextpart);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			//adding Content
			msg.setContent(mimemultipart);
			
			//step3:send mail using transport class
			
			Transport.send(msg);
			
			System.out.println("Email sent successfully ......");
			
			status = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return status;
		
	}

}
