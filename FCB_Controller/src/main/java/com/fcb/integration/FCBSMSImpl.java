package com.fcb.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service//("FCBSendSMS")
public class FCBSMSImpl implements FCBSendSMS {

	@Autowired
	private RestTemplate restTemplate;
 
	public String sendSMS(String mobileNumber, String sms) {
		String jsonResponce = null;
		if (mobileNumber != null && sms != null) {
			String url = "https://www.smsgatewayhub.com/api/mt/SendSMS?"
					+ "APIKey=kaushalk2367123456&senderid=TESTIN&channel=2&"
					+ "DCS=0&flashsms=0"
					+ "&number="+mobileNumber+"&text="+sms+""
					+ " message&route=13";
			jsonResponce = restTemplate.getForObject(url, String.class);
		}
		return jsonResponce;
	}

}
