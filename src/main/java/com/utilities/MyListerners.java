package com.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListerners implements ITestListener
{
	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println( context.getName() + " Test suite started");
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println( result.getMethod().getMethodName() + " test started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName() + " test success");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " Test failed");
	}
	
	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println(context.getName() + " Test suite started");
	}
}
