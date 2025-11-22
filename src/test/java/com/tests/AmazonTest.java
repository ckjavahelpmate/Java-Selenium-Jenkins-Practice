package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericlibrary.BaseTest;
import com.listeners.RetryListener;

public class AmazonTest extends BaseTest {

	@Test(groups = { "Regression", "ShopRegression" }, retryAnalyzer = RetryListener.class)
	public void amazonLaunchTest() {
		driver.get("https://www.amazon.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(false);
	}

}
