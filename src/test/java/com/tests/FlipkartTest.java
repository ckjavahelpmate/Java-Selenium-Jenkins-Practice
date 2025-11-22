package com.tests;

import org.testng.annotations.Test;

import com.genericlibrary.BaseTest;

public class FlipkartTest extends BaseTest{
	
	@Test( groups = { "Regression", "ShopRegression"})
	public void flipkartLaunchTest() 
	{
		driver.get("https://www.flipkart.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
