package com.nopcommerce.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName;
	public static String existingEmail, password, invalidEmail, notFoundEmail, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage ;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject	myProductReviewPage;
	private UserRewardPointPageObejct	rewardPointPage;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Hang";
		lastName = "Tran";
		existingEmail = "afc" + generakeFakeNumber() + "@mail.vn";
		invalidEmail = "afc@afc.com@.vn";
		notFoundEmail = "afc" + generakeFakeNumber() + "@mail.pro";
		password = "123456";
		incorrectPassword="654321";
		
		
		log.info("Register - Step 01 : Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		
		log.info("Register - Step 02 : Enter to Firstname text with value is '" + firstName +"'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Register - Step 03 : Enter to  Lastname textbox with value is '" + lastName +"'");
		registerPage.inputToLastnameTextbox(lastName);
		log.info("Register - Step 04 : Enter to Email textbox with value is '" + existingEmail +"'");
		registerPage.inputToEmailTextbox(existingEmail);
		
		log.info("Register - Step 05 : Enter to Password textbox with value is '" + password +"'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 06 : Enter to ConfirmPassword textbox with value is '" + password +"'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 07 : click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08 : Verify Register success message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println(existingEmail);
		
		log.info("Register - Step 09 : Click to Logout link");
		homePage= registerPage.clickToLogoutLink();
		
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

	public int generakeFakeNumber() {
		Random rand = new Random();
		return rand.nextInt();
	}

}
