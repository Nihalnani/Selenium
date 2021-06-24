package com.hrms.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Drag_Drop {
	
	 WebDriver driver;
		@BeforeClass
		public void startUp() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "F:/Newchromedriver/chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.get("https://jqueryui.com/droppable/");
		    driver.manage().window().maximize();
		    System.out.println(driver.getTitle());
		    Reporter.log("application opened");
		    Thread.sleep(2000);
		    
		}
		@Test
		public void drap_drop() throws InterruptedException {
			DOMConfigurator.configure("log4j.xml");
			
			driver.switchTo().frame(0);
			Actions action=new Actions(driver);
			action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
			 System.out.println("dragdrop completed");
			 Thread.sleep(4000);
			}
		
		@AfterClass()
			public void tearDown() {
				System.out.println("driver closed");
				
			}
		}


