package com.crm.qa.selenium.test;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

public class BaseTestCase {

	private BufferedWriter loggingWriter;
	private String baseUrl;
	private WebDriver driver;
	private static Map<ITestResult, List<Throwable>> verificationFailuresMap;
	protected String SYNC_TIME = "3000";
	
	public static List<Throwable> getVerificationFailures()
	{
		List<Throwable> verificationFailures = verificationFailuresMap
				.get(Reporter.getCurrentTestResult());
		return verificationFailures == null ? new ArrayList<Throwable>()
				: verificationFailures;
	}
}
