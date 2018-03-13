package com.crm.qa.webdriver.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.selenium.logging.ErrorEvent;
import com.crm.qa.selenium.logging.TestLogger;

/**
 * This class contains all generic functions for Webdrivers. e.g. findelement on
 * webpage with different parameters , click on button, switch to popup window.
 * 
 * @author ANIL
 * 
 */

public class WebDriverUtil {
	
	/**
	 * This method will locate the element on webpage with its Class Name. Here
	 * locator is class name of webelement.
	 * 
	 * @param locator
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException
	 */
	
	public static WebElement findElementByClassName(WebDriver driver, String locator) throws WebDriverUtilException{
		if(driver == null || (locator == null && locator =="")){
			TestLogger.log(new ErrorEvent(WebDriver.class, "Driver or Locator is NULL/EMPTY in method :findElementByClassName") );
			throw new WebDriverUtilException("Incorrect class name or driver");
		}
		WebElement webElement = driver.findElement(By.className(locator));
		return webElement;
	}
	
	/**
	 * This method will locate the element on webpage with its ID . Here locator
	 * is ID of webelement.
	 * 
	 * @param locator
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException
	 */
	public static WebElement findElementById(WebDriver driver, String locator)throws WebDriverUtilException{
		
		if(driver == null || (locator == null && locator =="")){
			TestLogger.log(new ErrorEvent(WebDriver.class, "Driver or Locator is NULL/EMPTY in method :findElementById"));
			throw new WebDriverUtilException("Incorrect class name or driver");
		}
		WebElement webElement = driver.findElement(By.id(locator));
		return webElement;
	}
	
	/**
	 * This method will locate the element on webpage with its CSS. Here locator
	 * is CSS of webelement.
	 * 
	 * @param locator
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException
	 */
	
	public static WebElement findElementByCssSelector(WebDriver driver, String locator) throws WebDriverUtilException{
		
		if(driver == null || (locator == null && locator == "")){
			TestLogger.log(new ErrorEvent(WebDriver.class, "Driver or Locator is NULL/EMPTY in method : findElementByCssSelector"));
			throw new WebDriverUtilException("Incorrect cssSelector or driver");
		}
		WebElement webElement = driver.findElement(By.cssSelector(locator));
		return webElement;
	}
	
	/**
	 * This method will locate the element on webpage with its Link Text. Here locator
	 * is Link Text of webelement.
	 * 
	 * @param locator
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException
	 */
	public static WebElement findElementByLinkText(WebDriver driver, String locator) throws WebDriverUtilException{
		
		if(driver == null || (locator == null && locator =="")){
			TestLogger.log(new ErrorEvent(WebDriver.class, "Driver or Locator is NULL/EMPTY in method : findElementByLinkText"));
			throw new WebDriverUtilException("Incorrect LinkText or driver");
		}
		WebElement webElement = driver.findElement(By.linkText(locator));
		return webElement;
	}
	
	/**
	 * This method will locate the element on webpage with its Name. Here
	 * locator is name of webelement.
	 * 
	 * @param locator
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException
	 */
	public static WebElement findElementByName(String locator, WebDriver driver) throws WebDriverUtilException
	{
		if (driver == null || (locator == null || locator == ""))
		{
			TestLogger.log(new ErrorEvent(WebDriver.class, "Driver or Locator is NULL/EMPTY in method :findElementByName"));
			throw new WebDriverUtilException("Incorrect Name or Webdriver");
		}
		WebElement webElement = driver.findElement(By.name(locator));
		return webElement;

	}

	/**
	 * This method will locate the element on webpage with its XPATH. Here
	 * locator is XPATH of webelement.
	 * 
	 * @param locator
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException
	 */
	public static WebElement findElementByXpath(String locator, WebDriver driver) throws WebDriverUtilException
	{
		if (driver == null || (locator == null || locator == ""))
		{
			TestLogger.log(new ErrorEvent(WebDriver.class, "Driver or Locator is NULL/EMPTY in method :findElementByXpath"));
			throw new WebDriverUtilException("Incorrect Xpath or Webdriver");
		}
		WebElement webElement = driver.findElement(By.xpath(locator));
		return webElement;

	}

	/**
	 * This method will locate the element on webpage with its Tag Name. Here
	 * locator is tag name of webelement.it returns the list of element
	 * 
	 * @param locator
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException
	 */
	public static List<WebElement> findElementsByTagName(String locator, WebDriver driver) throws WebDriverUtilException
	{
		if (driver == null || (locator == null || locator == ""))
		{
			TestLogger.log(new ErrorEvent(WebDriver.class, "Driver or Locator is NULL/EMPTY in method :findElementsByTagName"));
			throw new WebDriverUtilException("Incorrect TagName or Webdriver");
		}
		List<WebElement> webElements = driver.findElements(By.tagName(locator));
		return webElements;

	}
	
	/**
	 * This method will locate the element on webpage with its Tag Name. Here
	 * locator is tag name of webelement.
	 * 
	 * @param locator
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException
	 */
	public static WebElement findElementByTagName(String locator, WebDriver driver) throws WebDriverUtilException
	{
		if (driver == null || (locator == null || locator == ""))
		{
			TestLogger.log(new ErrorEvent(WebDriver.class, "Driver or Locator is NULL/EMPTY in method :findElementByTagName"));
			throw new WebDriverUtilException("Incorrect TagName or Webdriver");
		}
		WebElement webElement = driver.findElement(By.tagName(locator));
		return webElement;

	}


	
	
	
	

}
