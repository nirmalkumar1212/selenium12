package com.item.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.item.pages.ItemListPage;
import com.item.pages.SearchPage;
import com.item.setup.DriverSetup;
import com.item.setup.ExcelUtils;


public class SearchItemTest extends DriverSetup{
	SearchPage searchPage;
	ItemListPage itemListPage;
	public static String blankErrTxt;
	public static String emptymessage;
	public static String itemCodeTxt;
	public static String itemNameTxt;
	public static String itemPriceTxt;
	public static String itemDescriptionTxt;
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = getDriver();
}
	
	
@Test(priority=0)
	public void testBlankForItemCategory() throws Exception {
	 	ExcelUtils.setExcelFile();
	 	searchPage=new SearchPage(driver);
	 	String category = ExcelUtils.getCellData(1, 1);
		String startPrice = ExcelUtils.getCellData(1, 2);
		String endPrice = ExcelUtils.getCellData(1, 3);
		searchPage.setcategory(category);
		searchPage.setStartPrice(startPrice);
		searchPage.setEndPrice(endPrice);
		searchPage.clickSearch();
		blankErrTxt=searchPage.getErrorMessage();
		System.out.println(blankErrTxt);
		// fill the code
		
		
}
	
		
@Test(priority=1)
	public void testSearchForEmptyList() throws Exception {
		ExcelUtils.setExcelFile();
		searchPage=new SearchPage(driver);
		itemListPage=new ItemListPage(driver);
		String category = ExcelUtils.getCellData(2, 1);
		String startPrice = ExcelUtils.getCellData(2, 2);
		String endPrice = ExcelUtils.getCellData(2, 3);
		searchPage.setcategory(category);
		searchPage.setStartPrice(startPrice);
		searchPage.setEndPrice(endPrice);
		searchPage.clickSearch();
		Thread.sleep(5000);
		emptymessage = itemListPage.getEmptyMessage();
	}
	
	
	@Test(priority=2) 
	public void testSearchForResults() throws Exception {
		ExcelUtils.setExcelFile();
		searchPage=new SearchPage(driver);
		itemListPage=new ItemListPage(driver);
		String category = ExcelUtils.getCellData(3, 1);
		String startPrice = ExcelUtils.getCellData(3, 2);
		String endPrice = ExcelUtils.getCellData(3, 3);
		System.out.println(category);
		Thread.sleep(8000);
		searchPage.setcategory(category);
		searchPage.setStartPrice(startPrice);
		searchPage.setEndPrice(endPrice);
		searchPage.clickSearch();
		
		itemCodeTxt = itemListPage.getItemCode();
		itemNameTxt = itemListPage.getItemName();
		itemPriceTxt = itemListPage.getItemPrice();
		itemDescriptionTxt = itemListPage.getItemDescription();
	}
	
	
@AfterTest
	public void driverQuit(){
		driver.quit();
	}
	
	
}
