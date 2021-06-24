package com.hrms.LIB;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.hrms.utility.Log;




public class General extends Global{
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "F:/Newchromedriver/chromedriver.exe");
		 driver=new ChromeDriver();
		
		driver.navigate().to(url);
		System.out.println("Application opened");
		Reporter.log("application opened");
		Log.info("application opened");
		
		
	}
	public void login() {
		driver.findElement(By.name(txt_loginname)).sendKeys(username);
		driver.findElement(By.name(txt_password)).sendKeys(password);
		driver.findElement(By.name(btn_login)).click();
		System.out.println("login completed");
		Reporter.log("login completed");
		Log.info("login completed");
		
		
	}
	
	
	public void logout() {
		driver.findElement(By.linkText(link_logout)).click();
		System.out.println("logout completed");
		Reporter.log("logout completed");
		Log.info("logout completed");
		
		
		}
	public void addemployee() {
		System.out.println("new employee added");
		Reporter.log("new employee added");
		Log.info("new employee added");
	}
	public void delemployee() {
		System.out.println("new employee deleted");
		Reporter.log("new employee deleted");
		Log.info("new employee deleted");
	
	
	
	}
}
