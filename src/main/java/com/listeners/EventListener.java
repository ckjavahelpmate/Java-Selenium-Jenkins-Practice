package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utilities.ExtentReportManager;
import com.utilities.ScreenshotManager;

public class EventListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		ScreenshotManager.cleanFolder();
		ExtentReportManager.getExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = ExtentReportManager.getExtentReport().createTest(result.getMethod().getMethodName());
		ExtentReportManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.getTest().log(Status.PASS, result.getMethod().getMethodName() + " is Passed")
				.addScreenCaptureFromPath(ScreenshotManager.takeScreenshot(result.getMethod().getMethodName()));

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.getTest().log(Status.FAIL, result.getThrowable())
				.addScreenCaptureFromPath(ScreenshotManager.takeScreenshot(result.getMethod().getMethodName()));
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.flushExtentReport();
	}
}
