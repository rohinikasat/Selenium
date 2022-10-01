package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
//to remove show notification popup in chrome:		
    //Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();	    
		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);	    
		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();		    
		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);	    
		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
		WebDriver driver = new ChromeDriver(options);
	
		driver.get("https://www.marketwatch.com/");
		
    //because extra window was opening on this website
		driver.findElement(By.xpath("//*[@id=\"cx-scrim-wrapper\"]/button")).click();
		
//Step 1 switch to frame which has that particular table
		//WebElement frame1 = driver.findElement(By.id("LOCSTORAGE"));
		//driver.switchTo().frame(frame1);

//Step 2 get the number of rows		
		//when you select xpath of 1 row of that table, you'll get:
		//"/html/body/section[1]/div[2]/div/div[2]/div/div[1]/table/tbody/tr[1]"
		//when you remove [1] from then end you'll get common xpath for all the rows
		//this common xpath will now give us total number of rows un that table
		//"/html/body/section[1]/div[2]/div/div[2]/div/div[1]/table/tbody/tr"
		
		List<WebElement> rowelements = driver.findElements(
				By.xpath("/html/body/section[1]/div[2]/div/div[2]/div/div[1]/table/tbody/tr"));
		int rowsize = rowelements.size();
		System.out.println(rowsize);
		
//Step 3 get the number of columns	
		//same what you did to get the number of rows:
		//"/html/body/section[1]/div[2]/div/div[2]/div/div[1]/table/tbody/tr[1]/td"
		List<WebElement> columnelements = driver.findElements(
				By.xpath("/html/body/section[1]/div[2]/div/div[2]/div/div[1]/table/tbody/tr[1]/td"));
		int columnsize = columnelements.size();
		System.out.println(columnsize);
		
//Step 4 iterate rows and columns and get text and print it
		
		for (int i=1; i<=rowsize; i++ ) {
			for (int j=1; j<=columnsize; j++) {
				System.out.print( driver.findElement(
						By.xpath("/html/body/section[1]/div[2]/div/div[2]/div/div[1]/table/tbody/tr["+i+"]/td["+j+"]"))
				.getText()+ "    ");
			}
			System.out.println();
		}
		driver.close();
	}
}