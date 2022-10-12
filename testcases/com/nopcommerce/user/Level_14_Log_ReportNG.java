package com.nopcommerce.user;

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

public class Level_14_Log_ReportNG extends BaseTest {
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

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01 : Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		
		log.info("Register - Step 02 : Enter to Firstname text with value is '" + firstName +"'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Register - Step 03 : Enter to  Lastname textbox with value is '" + lastName +"'");
		registerPage.inputToLastnameTextbox(lastName);
		log.info("Register - Step 04 : Enter to Email textbox with value is '" + existingEmail +"'");
		registerPage.inputToEmailTextbox(existingEmail);
		
		log.info("Register - Step 05 : Enter to Password textbox with value is '" + validPassword +"'");
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Register - Step 06 : Enter to ConfirmPassword textbox with value is '" + validPassword +"'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Register - Step 07 : click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08 : Verify Register success message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println(existingEmail);
		
		log.info("Register - Step 09 : Click to Logout link");
		homePage= registerPage.clickToLogoutLink();
		
	}

	@Test
	public void User_02_Login()	{
		log.info("Login - Step 01 : Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login - Step 02 : Enter to Email textbox with value is '" + firstName +"'");
		loginPage.inputToEmailTextbox(existingEmail);
		
		log.info("Login - Step 03 : Enter to Password textbox with value is '" + validPassword +"'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Login - Step 04 : Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05 : Verify My Account link Display");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06 : Navigate to 'My Account' page");
		customerInfoPage = homePage.openMyAccountLink();
		
		log.info("Login - Step 07 : Verify Customer Infor page Display ");
		verifyTrue(customerInfoPage.isCustomerInforPageDisplayed());
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
