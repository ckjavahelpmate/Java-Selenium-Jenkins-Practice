package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> tests = new ThreadLocal<>();

	public static ExtentReports getExtentReport() {
		if (extentReport == null) {
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./test-output/ExtentReport.html");
			extentSparkReporter.config().setDocumentTitle("Java Selenium Jenkin Practice - Automation");
			extentSparkReporter.config().setReportName("CK");
			extentSparkReporter.config().setTheme(Theme.DARK);
			extentSparkReporter.config().setCss(".test { font-size: 16px; }");
			extentSparkReporter.config().setJs("console.log('Custom JS loaded');");

			extentReport = new ExtentReports();
			extentReport.attachReporter(extentSparkReporter);
		}
		return extentReport;
	}

	public static void setTest(ExtentTest extentTest) {
		tests.set(extentTest);
	}

	public static ExtentTest getTest() {
		return tests.get();
	}

	public static void flushExtentReport() {
		if (extentReport != null) {
			extentReport.flush();
		}
	}

}
