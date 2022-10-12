package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class Level_03_Page_Object_Login extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, existingEmail, validPassword, invalidEmail, notFoundEmail,incorrectPassword;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);

		firstName = "Hang";
		lastName = "Tran";
		existingEmail = "afc" + generakeFakeNumber() + "@mail.vn";
		invalidEmail = "afc@afc.com@.vn";
		notFoundEmail = "afc" + generakeFakeNumber() + "@mail.pro";
		validPassword = "123456";
		incorrectPassword="654321";

		System.out.println("Pre-Condition - Step 01: Click to register link");
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);

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
		registerPage.clickToLogoutLink();

		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		
	}
	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
		
	}
	@Test
	public void Login_03_Email_Not_Found() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfullErrorEmail(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfullErrorEmail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfullErrorEmail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}
	@Test
	public void Login_06_Valid_Email_Passowrd() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
