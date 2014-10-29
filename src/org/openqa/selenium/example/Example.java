package org.openqa.selenium.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class Example  {
    public static void main(String[] args) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.soyoustart.com/es/ofertas/e3-ssd-4.xml");

        // Find the text input element by its name
        try
        {
        	WebElement element = driver.findElement(By.className("order-button"));

        	
        	final String username = "cgarciabarrera@gmail.com";
    		final String password = "pnizvvlqpboqklxg";
     
    		Properties props = new Properties();
    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.starttls.enable", "true");
    		props.put("mail.smtp.host", "smtp.gmail.com");
    		props.put("mail.smtp.port", "587");
     
    		Session session = Session.getInstance(props,
    		  new javax.mail.Authenticator() {
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(username, password);
    			}
    		  });
     
    		try {
     
    			Message message = new MimeMessage(session);
    			message.setFrom(new InternetAddress("from-email@gmail.com"));
    			message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse("cgarciabarrera@gmail.com"));
    			message.setSubject("Hay servidor!!!!");
    			message.setText("Cuuurre");
     
    			Transport.send(message);
     
    			System.out.println("Done");
     
    		} catch (MessagingException e) {
    			throw new RuntimeException(e);
    		}
    		driver.close();
        
        }
        catch(Exception e)
        {
        	System.out.println("No hay nada");
        }


        // Check the title of the page


        driver.quit();
    }
}