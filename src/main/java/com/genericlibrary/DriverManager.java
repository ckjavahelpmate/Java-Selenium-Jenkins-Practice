package com.genericlibrary;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
	
	public static void setDriver(WebDriver driver)
	{
		drivers.set(driver);
	}
	
	public static WebDriver getDriver() 
	{
		return drivers.get();
	}
	
	public static void closeDriver() {
		
		if( drivers != null )
		{
			drivers.get().quit();
			drivers.remove();
		}
	}
	
}
