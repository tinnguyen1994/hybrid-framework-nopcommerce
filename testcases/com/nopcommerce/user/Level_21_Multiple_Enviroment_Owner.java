package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import ultilities.Enviroment;

public class Level_21_Multiple_Enviroment_Owner extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage;
	private UserDataMapper userData;
	Enviroment enviroment;
	
	
	
	@Parameters({ "browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		enviroment = ConfigFactory.create(Enviroment.class);
		
		driver = getBrowserDriver(browserName,enviroment.appUrl());

		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		
		existingEmail = userData.getEmailAddress() + generakeFakeNumber() + "@fpt.edu";

		
	}

	@Test
	public void User_01_Register(Method method) {

		log.info("Register - Step 01 : Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver, "Female");

		log.info("Register - Step 02 : Enter to Firstname text with value is '" + userData.getFirstName() + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register - Step 03 : Enter to  Lastname textbox with value is '" + userData.getLastName() + "'");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Register - Step 04 : Select dropdown ");
		registerPage.selectDropDownByName(driver, "DateOfBirthDay", userData.getDate());
		registerPage.selectDropDownByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectDropDownByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 05 : Enter to Email textbox with value is '" + existingEmail + "'");
		registerPage.inputToTextboxByID(driver, "Email", existingEmail);

		registerPage.clickToCheckBoxByLabel(driver, "Newsletter");

		log.info("Register - Step 06 : Enter to Password textbox with value is '" + userData.getPassword() + "'");
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register - Step 07 : Enter to ConfirmPassword textbox with value is '" + userData.getPassword() + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

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

		log.info("Login - Step 02 : Enter to Email textbox with value is '" + existingEmail + "'");
		// loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToTextboxByID(driver, "Email", existingEmail);

		log.info("Login - Step 03 : Enter to Password textbox with value is '" + userData.getPassword() + "'");
		// loginPage.inputToPasswordTextbox(validPassword);
		loginPage.inputToTextboxByID(driver, "Password", userData.getPassword());

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
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("My Account - Step 04 : Verify LastName textbox ");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("My Account - Step 05 : Verify Email textbox ");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), existingEmail);
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
