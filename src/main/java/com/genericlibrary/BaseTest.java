package com.genericlibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.listeners.EventListener;
import com.utilities.DriverManager;

@Listeners(EventListener.class)
public class BaseTest {
	protected WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void launchBrowser(String browser) {

//		WebDriverManager.edgedriver().setup();
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless=new"); // for Edge v112+
			options.addArguments("--disable-gpu");
			driver = new EdgeDriver(options);

		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverManager.setDriver(driver);
		this.driver = DriverManager.getDriver();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverManager.closeDriver();
	}
}
