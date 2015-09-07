package com.chu.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckUrl {
	public static void OpenLocal() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("localhost:8080");
		Thread.sleep(1*1000);
		driver.close();
		
	}

}
