package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class OrangeHRM_Login_GetText_GetTitle_GetCurrentURL {
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
		Thread.sleep(60000);
		driver.findElement(By.linkText("Logout")).click();
		
		//To get the Text and verify
		String ActualText = driver.findElement(By.id("logInPanelHeading")).getText();
	    String ExpectedText = "LOGIN Panel";
		Assert.assertEquals(ExpectedText, ActualText);
		
		// To get the currentURL and Verify
		String ActualURL = driver.getCurrentUrl();
		String ExpectedURL="ttps://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(ExpectedURL, ActualURL);
		
		// To Verify the Title
		String ActualTitle = driver.getTitle();
		String ExpectedTitle="OrangeHRM";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
	
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {

		//Launch the Chrome Browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //- Ctrl+Shift+O to download driver
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/login");
		Thread.sleep(6000);
	}

	@AfterTest
	public void afterTest() {
		//driver.close(); // Close the current browser
		driver.quit(); // Close all the browser opened by Selenium
	}


}

