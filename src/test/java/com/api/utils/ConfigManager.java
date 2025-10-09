//package com.api.utils;
//
//import java.io.File;
//import java.io.FileReader;
//import java.util.Properties;
//
//public class ConfigManager {
//
//	private static Properties properties = new Properties();
//
//	private ConfigManager() {
//
//		
//		// This constructor restrict user to create new object in different class
//	}
//
//	static {
//
//		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//				+ File.separator + "resources" + File.separator + "config" + File.separator + "config.properties");
//
//		FileReader fileReader = null;
//
//		try {
//			fileReader = new FileReader(file);
//			properties.load(fileReader);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static String getProperty(String Property) {
//
//		return properties.getProperty(Property);
//
//	}
//
//}
