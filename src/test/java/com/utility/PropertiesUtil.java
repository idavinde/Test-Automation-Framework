package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties prop = new Properties();
	private static String path = "/config/QA.properties";
	private static String env;

	private PropertiesUtil() {
		
	}

	static {
		
		env = System.getProperty("env","qa");
		env = env.toLowerCase().trim();
		
		switch(env) {
		
		case "qa" -> path = "/config/QA.properties";
		
		case "DEV" ->  path = "/config/DEV.properties";
		
		case "UAT" ->  path = "/config/UAT.properties";
		
		default -> path = "/config/QA.properties";
		
		}

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		try {
			prop.load(input);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getproperty(String key) {

		return prop.getProperty(key);
	}

}
