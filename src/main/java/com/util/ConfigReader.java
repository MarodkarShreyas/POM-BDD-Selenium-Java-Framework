package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	//Encapsulation - Access properties file thru method only
	/**
	 * This method used to load the properties from config.properties file
	 * @return It returns Properties prop object
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream FIS = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop.load(FIS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
