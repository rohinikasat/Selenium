package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		//to use JavaScriptExecutor you have to cast your driver object as JavaScriptExecutor
		JavascriptExecutor jsexec = (JavascriptExecutor)driver;
		
		//JavascriptExecutor to print title of the page
		String script = "return document.title;"; 
		String title = (String) jsexec.executeScript(script);
		System.out.println(title);
		
		//click button
		WebElement frame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame);
		jsexec.executeScript("myFunction()");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		//highlight the button
		WebElement button = driver.findElement(By.xpath("/html/body/button"));
		jsexec.executeScript("arguments[0].style.border='5px solid green'", button);
		
		//scroll
		driver.navigate().to("https://www.w3schools.com/");
		WebElement learnHowButton = driver.findElement(By.xpath("//*[@id=\"howto_padding\"]/a"));
		jsexec.executeScript("arguments[0].scrollIntoView(true);", learnHowButton);
		
	}

}
