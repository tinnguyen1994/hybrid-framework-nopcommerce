package com.jquery.test;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectJquery.DataTable.HomePageObject;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private List<String> actualAllCountryValues;
	private List<String> expectedAllCountryValues;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName,String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		homePage = pageObjectJquery.DataTable.PageGeneratorManager.getHomePage(driver);



	}

	
	public void Table_01_Paging() {
		homePage.openPagingByNumber("4");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("4"));
		homePage.openPagingByNumber("12");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("12"));
		homePage.openPagingByNumber("21");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("21"));
		homePage.openPagingByNumber("8");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("8"));
		homePage.openPagingByNumber("16");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("16"));
		homePage.openPagingByNumber("1");
		Assert.assertTrue(homePage.isPageNumberActived("1"));
		
	}



	
	public void Table_02_Enter_To_Header() {
		homePage.refreshUrl(driver);;
		homePage.enterToHeaderTextboxbyLabel("Country","Argentina");
		homePage.enterToHeaderTextboxbyLabel("Females","338282");
		homePage.enterToHeaderTextboxbyLabel("Males","349238");
		homePage.enterToHeaderTextboxbyLabel("Total","687522");
		sleepInSecond(3);
		homePage.enterToHeaderTextboxbyLabel("Country","Afghanistan");
		homePage.enterToHeaderTextboxbyLabel("Females","384187");
		homePage.enterToHeaderTextboxbyLabel("Males","407124");
		homePage.enterToHeaderTextboxbyLabel("Total","791312");
		sleepInSecond(2);
	}

	public void Table_03() {
		actualAllCountryValues =homePage.getValueEachRowAtAllPage();
		//assertEquals(actualAllCountryValues, expectedAllCountryValues);
		 
	}
	@Test
	public void Table_04() {
//		homePage.clickToIconFooter("1");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Album","2","Michel01");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Artist","2","John Kenny");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Year","2","1987");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Price","2","20");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Album","1","Henry 14");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Artist","1","Sakira");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Year","1","2012");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Price","1","40");
//		
//		
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin","1","Japan");
//		homePage.sleepInSecond(1);
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin","2","US");
//		homePage.sleepInSecond(1);
	homePage.selectDropdownByColumnNameAtRowNumber("Origin","1","Korea");
//		homePage.sleepInSecond(1);
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin","2","Taiwan");
		
		homePage.clickToLoadButton();
		homePage.sleepInSecond(1);
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist","2","John Kenny");
		homePage.enterToTextboxByColumnNameAtRowNumber("Year","4","1987");
		homePage.enterToTextboxByColumnNameAtRowNumber("Price","3","20");
		homePage.enterToTextboxByColumnNameAtRowNumber("Album","5","Henry 14");
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist","4","Sakira");
		homePage.enterToTextboxByColumnNameAtRowNumber("Year","3","2012");
		homePage.sleepInSecond(1);
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","1","Korea");
		homePage.sleepInSecond(1);
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","3","US");
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","4","Japan");
		homePage.sleepInSecond(1);
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","2","Taiwan");
		homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?","3");
		homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?","5");
		homePage.uncheckToCheckBoxByColumnNameAtRowNumber("With Poster?","1");
		homePage.uncheckToCheckBoxByColumnNameAtRowNumber("With Poster?","2");
		
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.clickToIconByRowNumber("3","Move Up");
		
		homePage.clickToIconByRowNumber("5","Remove Current Row");
		homePage.clickToIconByRowNumber("4","Remove Current Row");
		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.clickToIconByRowNumber("1","Remove Current Row");

		
		
	}
	
	


	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	public int generakeFakeNumber() {
		Random rand = new Random();
		return rand.nextInt();
	}


}
