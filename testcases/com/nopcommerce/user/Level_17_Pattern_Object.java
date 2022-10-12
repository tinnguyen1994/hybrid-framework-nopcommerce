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
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointPageObejct;
import reportConfig.ExtentManager;

public class Level_17_Pattern_Object extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword, invalidEmail, notFoundEmail, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage;
	private String date, month, year;

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
		incorrectPassword = "654321";
		date = "20";
		month = "August";
		year = "1992";

	}

	@Test
	public void User_01_Register(Method method) {

		log.info("Register - Step 01 : Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		
		registerPage.clickToRadioButtonByLabel(driver,"Female");

		log.info("Register - Step 02 : Enter to Firstname text with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 03 : Enter to  Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Step 04 : Select dropdown ");
		registerPage.selectDropDownByName(driver, "DateOfBirthDay", date);
		registerPage.selectDropDownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectDropDownByName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 05 : Enter to Email textbox with value is '" + existingEmail + "'");
		registerPage.inputToTextboxByID(driver, "Email", existingEmail);
		
		
		registerPage.clickToCheckBoxByLabel(driver,"Newsletter");

		log.info("Register - Step 06 : Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Register - Step 07 : Enter to ConfirmPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);
		
		registerPage.sleepInSecond(5);
		
		log.info("Register - Step 08 : click to Register button");
		registerPage.clickToButtonByText(driver, "Register");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 08 : Verify Register success message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println(existingEmail);

		log.info("Register - Step 09 : Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login(Method method) {
		log.info("Login - Step 01 : Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02 : Enter to Email textbox with value is '" + firstName + "'");
		// loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToTextboxByID(driver, "Email", existingEmail);

		log.info("Login - Step 03 : Enter to Password textbox with value is '" + validPassword + "'");
		// loginPage.inputToPasswordTextbox(validPassword);
		loginPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Login - Step 04 : Click to Login button");
		registerPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Login - Step 05 : Verify My Account link Display");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());	

		
	}
	@Test
	public void User_03_My_Account(Method method) {
		log.info("My Account - Step 01 : Navigate to 'My Account' page");
		customerInfoPage = homePage.openMyAccountLink();

		log.info("My Account - Step 02 : Verify Customer Infor page Display ");
		Assert.assertTrue(customerInfoPage.isCustomerInforPageDisplayed());
		
		log.info("My Account - Step 03 : Verify FirstName textbox ");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"FirstName"), firstName);
		
		log.info("My Account - Step 04 : Verify LastName textbox ");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"LastName"), lastName);
		
		log.info("My Account - Step 05 : Verify Email textbox ");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"Email"), existingEmail);
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
