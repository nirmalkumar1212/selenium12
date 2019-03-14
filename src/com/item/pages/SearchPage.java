package com.item.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	WebDriver driver;
	public static By category=By.name("category");
	public static By startPrice=By.name("startPrice");
	public static By endPrice=By.name("endPrice");
	public static By clickSearch=By.id("search");
	public static By result=By.id("errorMessage");
	
	public SearchPage (WebDriver driver){
	this.driver=driver;
}
	public void setcategory(String iCategory){
		driver.findElement(category).sendKeys(iCategory);
	}
	public void setStartPrice(String startsPrice){
		driver.findElement(startPrice).sendKeys(startsPrice);
	}
	public void setEndPrice(String endPrices){
		driver.findElement(endPrice).sendKeys(endPrices);
	}
	public String getErrorMessage(){
		return driver.findElement(result).getText();
	}
	public void clickSearch(){
		driver.findElement(clickSearch).click();
	}
}