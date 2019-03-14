package com.item.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemListPage {
	WebDriver driver;
	By Itemid=By.xpath("//tr[2]/td[1]");
	By Itemcode=By.xpath("//tr[2]/td[2]");
	By Itemname=By.xpath("//tr[2]/td[3]");
	By Price=By.xpath("//tr[2]/td[4]");
	By Description=By.xpath("//tr[2]/td[5]");
	By Category=By.xpath("//tr[2]/td[6]");
	By ErrorMsg=By.xpath("html/body/center/h4");
	
	//Private WebDriver driver;
	public ItemListPage(WebDriver driver){
		this.driver=driver;
	}
	public String getItemCode(){
		return driver.findElement(Itemcode).getText();
	}
	public String getItemName(){
		return driver.findElement(Itemname).getText();
	}
	public String getItemPrice(){
		return driver.findElement(Price).getText();
	}
	public String getItemDescription(){
		return driver.findElement(Description).getText();
	}
	public String getEmptyMessage(){
		String errorMessageTest = driver.findElement(ErrorMsg).getText();
		return errorMessageTest;
	}
}
