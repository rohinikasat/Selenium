package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().window().maximize();
		WebElement ddown = driver.findElement(By.xpath("//*[@id=\"continents\"]"));	
		Select select = new Select(ddown);
		
		WebElement firstOption = select.getFirstSelectedOption();
		System.out.println(firstOption.getText());
		
		select.selectByVisibleText("North America");
		
		Thread.sleep(2000);
		
		select.selectByIndex(2);
	}

}
