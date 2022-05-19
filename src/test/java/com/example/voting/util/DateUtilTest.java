package com.example.voting.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateUtilTest {

	@Test
	void testPlusMinutes() {
		int minutes = 15;
		int millisecond = minutes * 60 * 1000;

		Date startDate = Date.from(LocalDateTime.of(2022, 5, 19, 20, 0, 0).atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = DateUtil.plusMinutes(startDate, minutes);

		long result = endDate.getTime() - startDate.getTime();
		assertEquals(millisecond, result);
	}

}
