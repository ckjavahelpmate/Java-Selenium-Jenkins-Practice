package com.tests;

import org.testng.annotations.Test;

import com.genericlibrary.BaseTest;

public class AmazonTest extends BaseTest {
	
	@Test( groups = { "Regression", "ShopRegression"})
	public void amazonLaunchTest() 
	{
		driver.get("https://www.amazon.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
