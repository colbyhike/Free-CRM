package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		//TestUtil testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void brokenLinkOnHomePage() throws IOException{
	homePage.brokenLinkOnPage();
		
	}
	
	@Test
	public void isSelectedDealLink() throws InterruptedException{
		homePage.verifyfullSearchFormLink();
		//Assert.assertEquals("Full Search Form", "Full Search Form");
		Assert.assertTrue(homePage.verifyfullSearchFormLink(), "Full Search Form");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
