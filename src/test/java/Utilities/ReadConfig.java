package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties properties;
	
	String path = "C:\\cucumber\\ProjectCu\\config.properties";// no need relative path due to file is directly present in the project
	
	//constructior
	public ReadConfig()
	{
		try {
			properties = new Properties();
			FileInputStream fis  = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");
	}
}
	
