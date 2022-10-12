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
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class Level_03_Page_Object_Register extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName,lastName,emailAdress,password;
	UserHomePageObject homePage ;
	UserRegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		
		
		firstName="Hang";
		lastName="Tran";
		emailAdress = "aumationFC" + generakeFakeNumber() + "@gmail.vn";
		password="123456";
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPassowordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("8378123@123@gmail");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Correct_Data() throws InterruptedException {
		
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void Register_04_Existing_Email() {
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		
		registerPage.clickToRegisterButton();
		

		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
		
	}

	@Test
	public void Register_05_Paword_Less_Than_6_Chars() {
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		
		registerPage.clickToRegisterButton();
		

		Assert.assertEquals(registerPage.getErrorMessageAtPassowordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");


	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(emailAdress);
		
		registerPage.clickToRegisterButton();
		

		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

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


