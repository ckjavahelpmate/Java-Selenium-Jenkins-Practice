package com.tests;

import org.testng.annotations.Test;

import com.genericlibrary.BaseTest;

public class GoogleTest extends BaseTest{
	
	@Test( groups = { "Regression", "SocialRegression"})
	public void googleLaunchTest() 
	{
		driver.get("https://www.google.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
