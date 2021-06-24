package com.hrms.TestScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class TC_Excel_xls {
	public WebDriver driver;
	@BeforeClass
	public void Startup() {
			System.setProperty("webdriver.chrome.driver", "F:/Newchromedriver/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://127.0.0.1/orangehrm-2.6/index.php");
			Reporter.log("application opened");
			
			
			}
	
	@Test
	public void login() throws InterruptedException, BiffException, IOException {
		DOMConfigurator.configure("log4j.xml");
		
		FileInputStream file=new FileInputStream("F:/Excel Data/logindata.xls");
		Workbook w=Workbook.getWorkbook(file);
		Sheet st=w.getSheet(0);
//		in xls format sheet :column, row: index will consider from 0
		String uname=st.getCell(0, 1).getContents();
		String pword=st.getCell(1, 1).getContents();
//		Retriving login data from excel:
		driver.findElement(By.name("txtUserName")).sendKeys(uname);
		driver.findElement(By.name("txtPassword")).sendKeys(pword);
		driver.findElement(By.name("Submit")).click();
		Reporter.log("login completed");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Reporter.log("logout completed");
		
		
		
	}
	@AfterClass
	public void teardown() {
		driver.close();
		System.out.println("driver closed");
		Reporter.log("driver closed");
	}

}
