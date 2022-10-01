package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
//switching to frame at index 0
		//driver.switchTo().frame(0);
		//driver.findElement(By.xpath("/html/body/button")).click();
		
//switching to frame by name
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();

//accepting the alert		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		
//switching back to parent frame
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle()); //get title of parent window
		
//sendkeys method in the alert
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		
		Alert alertOnPage = driver.switchTo().alert();
		alertOnPage.sendKeys("Rohini");
		alertOnPage.accept();
		
		
	}

}
