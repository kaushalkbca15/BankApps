package com.fcb.integration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.fcb.util.FCBConstaint;

@Service
public class FCBJavaEmaiImpl implements FCBJavaEmail{
	
	@Autowired
	private MailSender mailSender;

	private Logger logger=Logger.getLogger(FCBJavaEmaiImpl.class);
	
	/**
	 * This method  is used for sending mail 
	 */
	public String sendMail(String to, String sub, String message) {
		String status=FCBConstaint.FCB_FAILURE;
		if(to!=null && sub!=null && message!=null){
			SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			simpleMailMessage.setTo(to);
			simpleMailMessage.setText(message);
			simpleMailMessage.setSubject(sub);
			simpleMailMessage.setFrom("kaushalbca15@gmail.com");
			try{
				mailSender.send(simpleMailMessage);
				status=FCBConstaint.FCB_SUCCESS;
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occure while sending mail: "+e);
			}//catch
		}//if
		return status;
	}//method
}//class
