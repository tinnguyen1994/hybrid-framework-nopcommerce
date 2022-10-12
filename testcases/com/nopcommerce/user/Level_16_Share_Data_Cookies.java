package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointPageObejct;

public class Level_16_Share_Data_Cookies extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword, invalidEmail, notFoundEmail, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage ;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject	myProductReviewPage;
	private UserRewardPointPageObejct	rewardPointPage;

	@Description("Register to System")
	@Severity(SeverityLevel.NORMAL)	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
//		existingEmail = Common_01_Register_End_User.existingEmail;
//		validPassword = Common_01_Register_End_User.password;
		log.info("Pre-Condition -Step 01 : Navigate to Login page");
		loginPage = homePage.openLoginPage();
		
		log.info("Pre-Condition -Step 02 : Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		loginPage.refreshUrl(driver);
		
		log.info("Pre-Condition -Step 03 : Verify 'My Account Page' displayed");
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
	


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int generakeFakeNumber() {
		Random rand = new Random();
		return rand.nextInt();
	}

}
