package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
	private final static int maxRetryCount = 2;
	private int retriedCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		while (retriedCount <= maxRetryCount) {
			retriedCount++;
			return true;
		}
		return false;
	}
}
