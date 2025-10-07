package com.api.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager2 {

	private static Properties properties = new Properties();
	private static final String path = "config/config.properties";

	private ConfigManager2() {

		// This constructor restrict user to create new object in different class
	}

	static {

		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		if (inputStream == null) {

			throw new RuntimeException("Cann't find the file at " + path);
		} else {

		}

		try {
			properties.load(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String Property) {

		return properties.getProperty(Property);

	}

}
