package com.OrangeHRM9;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Capture_ScreenShot_Example2 {
  
	ChromeDriver driver;
	//Absolute Path, rather use the relative path
	//String filePath_failure = "D:\\F Drive\\Selenium Training Data\\workspace\\Maven_Selenium_WebDriver_4\\Screenshot_Failure";
	String filePath_failure = System.getProperty("user.dir");
	
	String Relativepath_failure = filePath_failure+"\\Screenshot_Failure";
	String filePath_Success = filePath_failure+"\\Screenshot_Success";
	@Test(priority=2)
	public void OrangeHRM_Login() throws Exception
	{
		System.out.println(filePath_failure);
	//	driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	//	Thread.sleep(15000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	//	driver.findElement(By.linkText("Dashboardd")).isDisplayed();
		
		
        }

	@Test(priority=3)
	public void Logout()
		
		{
	    driver.findElement(By.id("welcome")).click();
	  //  driver.findElement(By.id("Logout")).click();
	  driver.findElement(By.id("Logoutt")).click();
	    
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
	
	@Test(priority=1)
	public void LaunchBrowser() throws InterruptedException
		
		{
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(15000);
		}
	
	
	
	@AfterMethod
public void CaptureScreenShot(ITestResult result) throws IOException  
{
	if ( ITestResult.FAILURE==result.getStatus())
	{
		 File Browserscreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(Browserscreenshot, new File(Relativepath_failure+"\\Login.png"));
		FileUtils.copyFile(Browserscreenshot, new File(Relativepath_failure +"\\"+result.getName()+"_"+System.currentTimeMillis() + ".png"));		 
   }else if ( ITestResult.SUCCESS==result.getStatus())
	{
		 File Browserscreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(Browserscreenshot, new File(filePath_Success+"\\Login.png"));
		FileUtils.copyFile(Browserscreenshot, new File(filePath_Success +"\\"+result.getName()+"_"+System.nanoTime() + ".png"));		 
 }
	
	//driver.quit();
}

}
