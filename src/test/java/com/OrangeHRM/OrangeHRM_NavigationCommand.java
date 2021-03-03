package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_NavigationCommand {

	
	@Test
	public void NavigationCommand() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); //- Ctrl+Shift+O to download driver
		driver.manage().window().maximize();
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(15000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Dashboard")).isDisplayed();  
		
		
		WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

		Actions action = new Actions(driver);

		action.moveToElement(admin).build().perform();
		//Thread.sleep(15000);
		WebElement usermanagement = driver.findElementByLinkText("User Management");
		action.moveToElement(usermanagement).build().perform();
		//Thread.sleep(5000);
		driver.findElementByLinkText("Users").click();
		driver.navigate().back();
		String Dashboadurl = driver.getCurrentUrl();
		System.out.println(Dashboadurl);
		driver.navigate().forward();
		Thread.sleep(5000);
		String Userdurl = driver.getCurrentUrl();
		System.out.println(Userdurl);
		driver.quit();
		//GetText
		//GetCurrentURL
		//GetTitle
}
}













