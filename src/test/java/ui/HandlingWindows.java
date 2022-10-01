package ui;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div/div[1]/div[1]/div/div[2]/hgf-cta[1]")).click();
		
//switching to new window that got opened
		Set<String> windowHandles = driver.getWindowHandles();//this returns a set of handle names for all open windows
		System.out.println(windowHandles);
		
		Iterator<String> iterator = windowHandles.iterator();
		
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		
		driver.switchTo().window(childWindow);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Ro");
		driver.findElement(By.name("UserLastName")).sendKeys("Ka");
		driver.findElement(By.name("UserTitle")).sendKeys("Student");
		driver.findElement(By.xpath("//a[contains(@data-page-cntrl,'next')]")).click();
		
	}

}
