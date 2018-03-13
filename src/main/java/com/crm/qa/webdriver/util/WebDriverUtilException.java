package com.crm.qa.webdriver.util;

/**
 * @author ANIL
 */

@SuppressWarnings("serial")
public class WebDriverUtilException extends Exception {
	
	//private static final long serialVersionUID = 1L;
	private String message = null;
	
	public WebDriverUtilException(){
		super();
	}
	
	public WebDriverUtilException(String message){
		super(message);
		this.message= message;
	}
	
	@Override
	public String toString(){
		return message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}

}
