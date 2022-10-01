package ui;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicWebDriverMethods {
	public static String browser = "chrome"; // External Configuration- XLS, CSV
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get("https://saucedemo.com/");
		driver.manage().window().maximize(); // maximize the current window

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		String title = driver.getTitle();
		System.out.println(title);

		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		//findElements
		List<WebElement> webelements = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
		System.out.println(webelements);
		
		//getWindowHandle
		driver.navigate().to("https://sugarcrm.com/");
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		
		//getWindowHandles
		//driver.findElement(By.xpath("//*[@id=\"menu-item-26632\"]/a/span[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);

		driver.close(); // using close instead of quit because only 1 browser window is open
	}
}
