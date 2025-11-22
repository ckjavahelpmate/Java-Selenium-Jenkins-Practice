package com.tests;

import org.testng.annotations.Test;

import com.genericlibrary.BaseTest;

public class YoutubeTest extends BaseTest{
	
	@Test( groups = { "Regression", "SocialRegression"})
	public void youtubeLaunchTest() 
	{
		driver.get("https://www.youtube.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
