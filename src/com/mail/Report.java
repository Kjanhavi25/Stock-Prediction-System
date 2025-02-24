package com.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Report {
	
	public void emailutility(String to)
	{

	String subject;
		String addtext;
		subject="Precautions";
		
		addtext="Quit Smoking,Excercise for atleast 30 min daily, Control High Bp,High Cholestrol and Diabetes,Eat diet with low salt,Maintain healthy weight and Reduce Stress.Best treatment for heart disease in below hospitals-Anand Rishiji Hospital and Medical Research center , Ahmednagar,Soykhedkar Hospital and Research center pri ltd, nashik,Dinanath Mangeshkar Hospital Pune,Kaushalya mediacal foundation trust hospital,Mumbai,Dhanvantari multispeciality Hospital ,Sangamner";
		
		  //Get the session object  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication("medicareproject2019@gmail.com","Arti@123");//change accordingly  
		   }  
		  });  
		   
		  //compose message  
		  try {  
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress());//change accordingly  
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		   message.setSubject(subject);  
		   //message.setText(addtext); 
		   
		     
		   message.setText(addtext);
		   //send message  
		   Transport.send(message);  
		  
		   System.out.println("message sent successfully");  
		   

		  }
		  catch (MessagingException e) 
		  {
              e.printStackTrace();
		  }
	
		   
	}

}
