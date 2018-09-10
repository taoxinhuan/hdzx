package com.taoxinhuan.main.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author taoxi
 *
 */
public class DateUtil {

	public static String getStringDateFormat(Date date) {
		if (null != date) {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			String format = f.format(date);
			return format;
		}
		return null;

	}

}
