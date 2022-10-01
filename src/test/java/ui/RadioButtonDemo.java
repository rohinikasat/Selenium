package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("radioval")).click();
		// this will return boolean
		System.out.println(driver.findElement(By.name("radioval")).isSelected());
		Thread.sleep(3000);

		// how many checkboxes are there on the page
		System.out.println(driver.findElements(By.xpath("//input[@type='radio']")).size());

		driver.close();
	}

}
