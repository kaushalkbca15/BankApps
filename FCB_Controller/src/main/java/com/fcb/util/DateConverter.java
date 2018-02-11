package com.fcb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateConverter {

	private static Logger logger = Logger.getLogger(DateConverter.class);

	public static Date setDate(String stringDate) {
		Date date = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (stringDate != null) {
			try {
				date = dateFormat.parse(stringDate);
			} catch (ParseException e) {
				logger.error("Exception occure while converting String to date formate " + e);
			}
		}
		return date;
	}
}
