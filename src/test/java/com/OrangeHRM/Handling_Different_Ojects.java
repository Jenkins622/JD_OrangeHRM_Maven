package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Handling_Different_Ojects {
	ChromeDriver driver;
	
	
  @Test
  public void RadioButton() throws InterruptedException {
//	  Thread.sleep(60000);
	WebElement radio =  driver.findElementById("female");
	 radio.click();
	// Thread.sleep(60000);
	
	 
  }
  
  @Test
  public void CheckBox() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@value='Performance']")).click();
	 // Thread.sleep(60000);
  }
  
  @Test
  public void SelectDropDownValue() throws InterruptedException {
	  WebElement  mySelectElement = driver.findElement(By.id("testingDropdown"));
	  Select dropdown = new Select(mySelectElement);
	  dropdown.selectByIndex(1);
	 // Thread.sleep(60000);
	  
  }
  
  @Test
  public void DoubleClick() throws InterruptedException {
	  WebElement rightClickElement = driver.findElement(By.id("dblClkBtn"));
	  Actions action = new Actions(driver);
	  action.doubleClick(rightClickElement).build().perform();
	  Alert alert = driver.switchTo().alert();
	  String alertText = alert.getText();
	  System.out.println(alertText);
	  alert.accept();
	 // Thread.sleep(6000);
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
		//Launch the Chrome Browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //- Ctrl+Shift+O to download driver
		driver.manage().window().maximize();
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
		Thread.sleep(15000);
  }

  @AfterTest
  public void afterTest() {
	//driver.close(); // Close the current browser
	//driver.quit(); // Close all the browser opened by Selenium
  }

}
