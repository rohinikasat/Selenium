package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEventsDemo {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		WebElement sourceTextArea = driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]//div[2]/pre/span"));
		
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.keyDown(sourceTextArea, Keys.COMMAND).sendKeys("a").sendKeys("c").build().perform();
		WebElement destinationTextArea = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]//div[3]/pre"));
		Thread.sleep(2000);
		action.keyDown(destinationTextArea, Keys.COMMAND).sendKeys("a").sendKeys("v").build().perform();

	}

}
