package qman;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class getServerInfo {
	String result = "";
	String resultport = "";
	InputStream inputStream;
 
	public String getPropValueIP() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "serverinfo.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			String serveripaddress = prop.getProperty("serveripaddress");
			
			result = serveripaddress;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
	
	public String getPropValuePort() throws IOException {
		 

		try {
			Properties prop = new Properties();
			String propFileName = "serverinfo.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			String port = prop.getProperty("port");
			
			resultport = port;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return resultport;
	}
}
