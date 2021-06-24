package com.hrms.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.hrms.LIB.General;

public class TC_Login_Logout {

//	public static void main(String args[]) {
	
	@Test
	public void login() {
		
		DOMConfigurator.configure("log4j.xml");
		General g=new General();
		g.openApplication();
		g.login();
		g.logout();
		

	}

}
