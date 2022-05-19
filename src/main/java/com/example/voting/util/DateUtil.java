package com.example.voting.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date plusMinutes(Date date, int duration) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, duration);
		return calendar.getTime();
	}
}
