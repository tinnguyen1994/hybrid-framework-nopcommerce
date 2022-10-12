package com.saucelab.sort;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointPageObejct;
import pageObject.sauceLab.LoginPageObject;
import pageObject.sauceLab.PageGeneretorManager_SauceLab;
import pageObject.sauceLab.ProductPageObject;
import reportConfig.ExtentManager;

public class Level_18_Sort_Asc_Desc extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;
	String userName="standard_user"	;
	String password = "secret_sauce";

	@Parameters({"browser","appUrl"})
	@BeforeClass
	public void beforeClass(String browserName,String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		loginPage = PageGeneretorManager_SauceLab.getLoginPage(driver);
		

		productPage = loginPage.loginAsProductPage(userName, password);
		
		
		

	}

	@Test
	public void Sort_01_Name_Product(Method method) {
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductNameSortByAscending());

		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductNameSortByDescending());
	}

	@Test
	public void Sort_02_Price_Product(Method method) {
		
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}
	@Test
	public void User_03_My_Account(Method method) {}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int generakeFakeNumber() {
		Random rand = new Random();
		return rand.nextInt();
	}

}
