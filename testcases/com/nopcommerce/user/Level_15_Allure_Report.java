package com.nopcommerce.user;

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
import reportConfig.ExtentManager;

public class Level_15_Allure_Report extends BaseTest {
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

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Hang";
		lastName = "Tran";
		existingEmail = "afc" + generakeFakeNumber() + "@mail.vn";
		invalidEmail = "afc@afc.com@.vn";
		notFoundEmail = "afc" + generakeFakeNumber() + "@mail.pro";
		validPassword = "123456";
		incorrectPassword="654321";


	}
	@Description("Register to System")
	@Severity(SeverityLevel.NORMAL)	
	@Test
	public void User_01_Register() {

		registerPage = homePage.openRegisterPage();
		
		registerPage.inputToFirstnameTextbox(firstName);
		
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		
		registerPage.inputToPasswordTextbox(validPassword);
		
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println(existingEmail);
		
		homePage= registerPage.clickToLogoutLink();
		
	}
	
	@Description("Login to System")
	@Test
	public void User_02_Login()	{
		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(existingEmail);
		
		loginPage.inputToPasswordTextbox(validPassword);
		
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		customerInfoPage = homePage.openMyAccountLink();
		
		Assert.assertTrue(customerInfoPage.isCustomerInforPageDisplayed());
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
