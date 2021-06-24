package com.hrms.TestScripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Screenshot {
	WebDriver driver;
	@BeforeMethod
	public void statUp() {
		System.setProperty("webdriver.chrome.driver", "F:/Newchromedriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://127.0.0.1/orangehrm-2.6/index.php");
		Reporter.log("application opened");
}
	@Test
	public void screenshot() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		try {
			driver.navigate().to("http://127.0.0.1/orangehrm-2.6/index.php");
			driver.findElement(By.name("txtUserName")).sendKeys("admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@type='Submit']")).click();
			System.out.println("Login completed");
			Reporter.log("login completed");
					
	//Mouse-over actions:
//			PIM:
			Actions ac=new Actions(driver);
			ac.moveToElement(driver.findElement(By.linkText("PIM23"))).perform();
			Reporter.log("Mouse over completed");
			Thread.sleep(3000);
			driver.findElement(By.linkText("Employee Lists")).click();
			System.out.println("clicked on submenu");
			Reporter.log("clicked on submenu 1");

		}
		catch(Exception e) {
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f,new File( "F:/TestReports.png"));
			System.out.println("screenshot captured");
			Reporter.log("screenshot captured");
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
		

}
