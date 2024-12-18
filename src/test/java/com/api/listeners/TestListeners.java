package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	private static final Logger Logger = LogManager.getLogger(TestListeners.class);

	public void onStart(ITestContext context) {

		Logger.info("Test Suite Started");
	}

	public void onTestStart(ITestResult result) {

		Logger.info("On Test Start!!" + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		Logger.info("Passed!!" + result.getMethod().getMethodName());
		Logger.info("Description" + result.getMethod().getDescription());
	}

	public void onTestFailure(ITestResult result) {

		Logger.error("Test failed");
	}

	public void onTestSkipped(ITestResult result) {

		Logger.info("Test Skipped"+ result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {

		Logger.info("Test Suite Finished");
	}

}
