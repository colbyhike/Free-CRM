package com.crm.qa.base;

import org.testng.AssertJUnit;

import static org.testng.Assert.assertNotEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.crm.qa.util.TestUtil;

public  class TestBase  {
	public static WebDriver driver;
	public static Properties prop;
	private static Map<ITestResult, List<Throwable>> verificationFailuresMap;

	
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:/Workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--start-maxmized");
			    
			System.setProperty("WebDriver.chrome.driver", "D:\\InstalledSoftwares\\LatestSelenium\\chromedriver");
			driver = new ChromeDriver(co);
		}
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thoughtworks.selenium.SeleneseTestBase#verifyTrue(boolean)
	 */
	public void verifyTrue(boolean condition)
	{
		try
		{
			AssertJUnit.assertTrue(condition);
		} catch (Throwable e)
		{
			addVerificationFailure(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thoughtworks.selenium.SeleneseTestBase#verifyEquals(boolean,
	 * boolean)
	 */
	public void verifyEquals(boolean actual, boolean expected)
	{
		try
		{
			AssertJUnit.assertEquals(actual, expected);
		} catch (Throwable e)
		{
			addVerificationFailure(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thoughtworks.selenium.SeleneseTestBase#verifyFalse(boolean)
	 */
	public void verifyFalse(boolean b)
	{
		try
		{
			AssertJUnit.assertFalse(b);
		} catch (Throwable e)
		{
			addVerificationFailure(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thoughtworks.selenium.SeleneseTestBase#verifyNotEquals(java.lang.
	 * Object, java.lang.Object)
	 */
	public void verifyNotEquals(Object s1, Object s2)
	{
		try
		{
			assertNotEquals(s1, s2);
		} catch (Throwable e)
		{
			addVerificationFailure(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thoughtworks.selenium.SeleneseTestBase#verifyNotEquals(boolean,
	 * boolean)
	 */
	public void verifyNotEquals(boolean s1, boolean s2)
	{
		try
		{
			assertNotEquals(s1, s2);
		} catch (Throwable e)
		{
			addVerificationFailure(e);
		}
	}

	/**
	 * This method is a wrapper over SeleneseTestBase assertEquals
	 * 
	 * @param actual
	 * @param expected
	 */
	public void verifyEquals(Object[] actual, Object[] expected)
	{
		try
		{
			AssertJUnit.assertEquals(actual, expected);
		} catch (Throwable e)
		{
			addVerificationFailure(e);
		}
	}

	/**
	 * This method fetches a list of all verification faliures
	 * 
	 * @return List<Throwable>
	 */
	public  static  List<Throwable> getVerificationFailures()
	{
		List<Throwable> verificationFailures = verificationFailuresMap
				.get(Reporter.getCurrentTestResult());
		return verificationFailures == null ? new ArrayList<Throwable>()
				: verificationFailures;
	}

	private static void addVerificationFailure(Throwable e)
	{
		List<Throwable> verificationFailures = getVerificationFailures();
		verificationFailuresMap.put(Reporter.getCurrentTestResult(),
				verificationFailures);

		verificationFailures.add(e);
	}


	
	
	

}
