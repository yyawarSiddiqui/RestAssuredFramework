package com.api.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {

	// Define the date format pattern
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * Returns today's date in yyyy-MM-dd format.
	 */
	public static String getTodayDate() {
		return LocalDate.now().format(FORMATTER);
	}

	/**
	 * Returns a date N days from today in yyyy-MM-dd format. Use negative value for
	 * past dates.
	 *
	 * Example: getDateAfterDays(5) -> 5 days from now getDateAfterDays(-3) -> 3
	 * days before today
	 */
	public static String getDateAfterDays(int days) {
		return LocalDate.now().plusDays(days).format(FORMATTER);
	}

	/**
	 * Returns a custom date string in yyyy-MM-dd format for the given year, month,
	 * and day.
	 */
	public static String getCustomDate(int year, int month, int day) {
		return LocalDate.of(year, month, day).format(FORMATTER);
	}
}
