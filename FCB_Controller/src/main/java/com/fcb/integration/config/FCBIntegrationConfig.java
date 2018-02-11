package com.fcb.integration.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages="com.fcb.integration")
public class FCBIntegrationConfig {
	
	@Bean
	public RestTemplate createRestTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public MailSender createMailSender(){
		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		//configure gmail host,pot,smtp
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("kaushalk2367@gmail.com");
		mailSender.setPassword("kaushalk236@#");
		mailSender.setJavaMailProperties(this.getProperties());
	
		return mailSender;
	}
	public Properties getProperties(){
		Properties props=new Properties();
		 props.put("mail.transport.protocol","smtp");
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable","true");
		 props.put("mail.debug","true");
		return props;
	}
	 
	/*@Bean(autowire = Autowire.BY_TYPE)
	public JmsTemplate fcbJmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		return jmsTemplate;
	}*/
	   
}
