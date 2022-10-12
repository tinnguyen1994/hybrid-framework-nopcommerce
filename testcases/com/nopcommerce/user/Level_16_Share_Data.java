package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointPageObejct;

public class Level_16_Share_Data extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword, invalidEmail, notFoundEmail, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage ;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject	myProductReviewPage;
	private UserRewardPointPageObejct	rewardPointPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		existingEmail=Common_01_Register_End_User.existingEmail;
		validPassword=Common_01_Register_End_User.password;

		homePage = PageGeneratorManager.getUserHomePage(driver);
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		

	}
	@Test
	public void Search_01_Empty_Data() {
		
	}
	@Test
	public void Search_02_Relative_Product_Name() {
		
	}
	@Test
	public void Search_03_Absolute_Product_Name() {
		
	}
	
	@Test
	public void Search_04_Parent_Category() {
		
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
