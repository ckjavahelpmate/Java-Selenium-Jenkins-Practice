package com.utilities;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> tests = new ThreadLocal<>();

	private static long executionStartTime;
	private static ThreadLocal<Long> testStartTimes = new ThreadLocal<Long>();
	private static ConcurrentLinkedQueue<Long> allExecutionTimes = new ConcurrentLinkedQueue<>();

	public static ExtentReports getExtentReport() {
		if (extentReport == null) {
			executionStartTime = System.currentTimeMillis();
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./test-output/ExtentReport.html");
			extentSparkReporter.config().setDocumentTitle("Java Selenium Jenkin Practice - Automation");
			extentSparkReporter.config().setReportName("Automation Test Result");
			extentSparkReporter.config().setTheme(Theme.DARK);
			extentSparkReporter.config().setCss(".test { font-size: 16px; }");
			extentSparkReporter.config().setJs("console.log('Custom JS loaded');");

			extentReport = new ExtentReports();
			extentReport.setSystemInfo("OS" ,  System.getProperty("os.name"));
			extentReport.setSystemInfo("Executed By" ,System.getProperty("user.name"));
			extentReport.attachReporter(extentSparkReporter);
		}
		return extentReport;
	}

	public static void setTest(ExtentTest extentTest) {
		testStartTimes.set(System.currentTimeMillis());
		tests.set(extentTest);
	}

	public static ExtentTest getTest() {
		return tests.get();
	}

	public static void flushExtentReport() {
		long totalExecutionTime = System.currentTimeMillis() - executionStartTime;
		extentReport.setSystemInfo("Total Execution time", totalExecutionTime + "ms");
		long maxtime = 0, minTime = Long.MAX_VALUE, totalTime = 0;
		double averageTime = 0;
		for (Long time : allExecutionTimes) {
			totalTime += time;
			if (time > maxtime)
				maxtime = time;
			if (time < minTime)
				minTime = time;
		}
		averageTime = totalTime / allExecutionTimes.size();
		extentReport.setSystemInfo("Total Script Execution Time", totalTime + "ms");
		extentReport.setSystemInfo("Max Execution Time / Script", maxtime + "ms");
		extentReport.setSystemInfo("Min Execution Time / Script", minTime + "ms");
		extentReport.setSystemInfo("Average Execution Time / Script", averageTime + "ms");

		if (extentReport != null) {
			extentReport.flush();
		}
	}

	public static void logTestExecutionTime(long testFinishTime) {
		long testExecutionTime = testFinishTime - testStartTimes.get();
		tests.get().log(Status.INFO, "Suite Execution time: " + testExecutionTime + " ms");
		allExecutionTimes.add(testExecutionTime);
	}
}
