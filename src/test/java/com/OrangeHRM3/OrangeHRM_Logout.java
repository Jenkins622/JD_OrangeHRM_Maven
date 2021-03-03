package com.OrangeHRM3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Logout {
	ChromeDriver driver;

	public void LaunchBrowser() throws InterruptedException{
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); //- Ctrl+Shift+O to download driver
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}
	
	
	
public void CloseBrowser(){
		
	}


public void Loin_Succsessful_Scenario(){
	
}


	
	@Test
	public void Login_SUccessful_Scenario() throws InterruptedException {
		//Launch the Chrome Browser
		
		Thread.sleep(6000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	//	driver.close(); // Close the current browser
		driver.quit(); // Close all the browser opened by Selenium
	}

}
