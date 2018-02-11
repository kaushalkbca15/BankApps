package com.fcb.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtile {
	private static final ObjectMapper mapper = new ObjectMapper();
	static final Logger logger = Logger.getLogger(JSONUtile.class);

	public static String convertJavaToJson(Object object) {
		String json = null;
		if (object != null) {
			try {
				json = mapper.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				logger.error("Exception occure while convertion Object to JSON :"+e);
			}
		}
		return json;
	}
	public static <T> T convertJsonToJava(Class<T> cls,String json) {
		T responce=null;
		if(cls!=null&&json!=null) {
			try {
				responce=mapper.readValue(json,cls);
			} catch (JsonParseException e) {
				logger.error("Exception occure while comvertion Json to JAVA Object:"+e);
			} catch (JsonMappingException e) {
				logger.error("Exception occure while comvertion Json to JAVA Object:"+e);				
			} catch (IOException e) {
				logger.error("Exception occure while comvertion Json to JAVA Object:"+e);
			}
		}
		return responce;
	}

}
