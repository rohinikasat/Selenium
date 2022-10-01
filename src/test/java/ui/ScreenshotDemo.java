package ui;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		Date currentDate = new Date();
		String currentDateString = currentDate.toString().replace(" ", "-").replace(":", "-");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		//to take screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//to save or view screenshot
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenshot-"+currentDateString+ ".png"));
	}

}
