package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithWebElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("user-name")).clear();
		System.out.println("getAttribute: " + driver.findElement(By.name("user-name")).getAttribute("class"));
		System.out.println("getCssValue: " + driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getCssValue("text-transform"));
		System.out.println("getSize: " + driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getSize());
		System.out.println("getLocation: " + driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getLocation());
		System.out.println("getTagName: " + driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getTagName());
		System.out.println("getText: " + driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4")).getText());
		System.out.println("isDisplayed: " + driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isDisplayed());
		System.out.println("isEnabled: " + driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isEnabled());
		System.out.println("isSelected: " + driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isSelected());
		
		driver.close();
	}

}
