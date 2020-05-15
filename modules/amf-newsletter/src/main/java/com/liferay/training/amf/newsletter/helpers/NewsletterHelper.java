package com.liferay.training.amf.newsletter.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsletterHelper {

	public static String formatCreateDate(Date date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");  
	    String formattedDate= formatter.format(date);
	    return formattedDate;
	}
	
}
