package com.tests;

import org.testng.annotations.Test;

import com.genericlibrary.BaseTest;

public class MyntraTest extends BaseTest{
	
	@Test( groups = { "Regression", "ShopRegression"})
	public void myntraLaunchTest() 
	{
		driver.get("https://www.myntra.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
