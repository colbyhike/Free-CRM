package com.crm.qa.Listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Adapter which listens to the tests.
 * 
 * @author ANIL
 * 
 */
public class TestListenerAdapter implements IInvokedMethodListener
{

	public void afterInvocation(IInvokedMethod method, ITestResult result)
	{
	}

	public void beforeInvocation(IInvokedMethod method, ITestResult result)
	{
	}

}
