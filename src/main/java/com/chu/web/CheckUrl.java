package com.chu.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckUrl {
	final static Logger logger = Logger.getLogger(CheckUrl.class);
	public static void OpenLocal() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("localhost:8080");
		Thread.sleep(1*1000);
		driver.close();
		logger.info("close the driver");
		
	}

}
