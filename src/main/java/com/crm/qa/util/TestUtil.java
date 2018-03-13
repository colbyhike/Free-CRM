package com.crm.qa.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public void brokenLinkTest() throws IOException{
		//1. Get the list of all the links and images.
		
				List<WebElement> linkList = driver.findElements(By.tagName("a"));
				linkList.addAll(driver.findElements(By.tagName("img")));
				System.out.println("No. available of link--->"+linkList.size());
				System.out.println(linkList);
				
				List<WebElement> activeList = new ArrayList<WebElement>();
				
				//2. Iterate all the linkList and Exclude all the links and img doesn't have href Attribute /*&& (linkList.get(i).getAttribute("href").contains("javascript"))*/
				
				for(int i=0; i<linkList.size(); i++){
					System.out.println(linkList.get(i).getAttribute("href"));
					if(linkList.get(i).getAttribute("href") != null && (!linkList.get(i).getAttribute("href").contains("javascript")) ){
					 activeList.add(linkList.get(i));
					 
					}
				}
				
				//3. Get the size of Active linkList
				System.out.println("size of active link and img---->"+activeList.size());
				//System.out.println("total links---"+ activeList);
				
				//4. check the href url with httpConnection api
				
				for(int j=0; j<activeList.size(); j++){
					HttpURLConnection connection = (HttpURLConnection) new URL(activeList.get(j).getAttribute("href")).openConnection();
					connection.connect();
					String response = connection.getResponseMessage();
					connection.disconnect();
					
					System.out.println(activeList.get(j).getAttribute("href")+"-----"+response);
				}
				
	}
	

}
