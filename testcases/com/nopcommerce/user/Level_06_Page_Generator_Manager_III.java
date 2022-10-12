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
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword, invalidEmail, notFoundEmail,incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage= PageGeneratorManager.getUserHomePage(driver);

		firstName = "Hang";
		lastName = "Tran";
		existingEmail = "afc" + generakeFakeNumber() + "@mail.vn";
		invalidEmail = "afc@afc.com@.vn";
		notFoundEmail = "afc" + generakeFakeNumber() + "@mail.pro";
		validPassword = "123456";
		incorrectPassword="654321";

		System.out.println("Pre-Condition - Step 01: Click to register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-Condition - Step 03: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-Condition - Step 05: Click to log out link");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.openLoginPage();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		
	}
	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
		
	}
	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfullErrorEmail(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfullErrorEmail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfullErrorEmail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}
	@Test
	public void Login_06_Valid_Email_Passowrd() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		customerInfoPage = homePage.openMyAccountLink();
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
