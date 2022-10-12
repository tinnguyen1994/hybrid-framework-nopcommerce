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
import pageObjectJquery.UploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	private pageObjectJquery.UploadFile.HomePageObject homePage;
	String javaFileName="Java.jpg";
	String pythonFileName="Python.jpg";
	String csharpFileName="CSharp.jpg";
	String nodeJSFileName="NodeJs.jpg";
	String[] multipleFileName = {javaFileName,pythonFileName,csharpFileName,nodeJSFileName};
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage=PageGeneratorManager.getHomePage(driver);

	}
	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, csharpFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileUpLinkLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileUpImageLoadedByName(csharpFileName));
		
		
		
	}
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshUrl(driver);
		homePage.uploadMultipleFiles(driver, multipleFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(nodeJSFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileUpLinkLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileUpLinkLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileUpLinkLoadedByName(nodeJSFileName));
		Assert.assertTrue(homePage.isFileUpLinkLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileUpImageLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileUpImageLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileUpImageLoadedByName(nodeJSFileName));
		Assert.assertTrue(homePage.isFileUpImageLoadedByName(javaFileName));
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}

	public int generakeFakeNumber() {
		Random rand = new Random();
		return rand.nextInt();
	}

}
