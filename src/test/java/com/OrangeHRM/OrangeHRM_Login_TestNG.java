package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_TestNG {
	ChromeDriver driver;
	@Test(priority=1)
	public void Login() {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();  
	}

	@Test(priority=2)
	public void Logout() throws InterruptedException {
		
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(30000);
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {

		//Launch the Chrome Browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //- Ctrl+Shift+O to download driver
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(6000);
	}

	@AfterTest
	public void afterTest() {
		//driver.close(); // Close the current browser
		driver.quit(); // Close all the browser opened by Selenium
	}


}

