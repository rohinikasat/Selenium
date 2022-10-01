package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWriteFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		
		//Read from file
		FileInputStream inputStream = new FileInputStream("/Users/rishimalani/eclipse-ee/Selenium/src/test/resources/properties/testdata.properties");
		properties.load(inputStream);
		String currentBrowser = properties.getProperty("browser");
		System.out.println(currentBrowser);
		String currentUrl = properties.getProperty("url");
		System.out.println(currentUrl);
		
		//Write to file
		FileOutputStream outputStream = new FileOutputStream("/Users/rishimalani/eclipse-ee/Selenium/src/test/resources/properties/testdata.properties");
		properties.setProperty("testdata", "23445");
		properties.store(outputStream, "This is customer data");
	}

}
