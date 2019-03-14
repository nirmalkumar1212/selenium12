package com.item.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {
	public static String baseUrl = "http://apps.qa2qe.cognizant.e-box.co.in/Item_search_4500/";
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\ItemDetails\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(DriverSetup.baseUrl);
		return driver;
	}

}
