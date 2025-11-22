package com.tests;

import org.testng.annotations.Test;

import com.genericlibrary.BaseTest;

public class FacebookTest extends BaseTest {
	
	@Test( groups = { "Regression", "SocialRegression"})
	public void facebookLaunchTest() 
	{
		driver.get("https://www.facebook.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
