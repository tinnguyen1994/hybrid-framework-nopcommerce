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

public class Level_09_Dynamic_Locator extends BaseTest {
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
	public void User_01_Register_And_Login() {
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println(existingEmail);
		homePage= registerPage.clickToLogoutLink();
		
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		customerInfoPage = homePage.openMyAccountLink();
		verifyTrue(customerInfoPage.isCustomerInforPageDisplayed());
	}



	@Test
	public void User_02_Switch_Page() {
		addressPage = customerInfoPage.openAddressPage(driver);
		
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		
		addressPage = rewardPointPage.openAddressPage(driver);
		
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	}
	@Test
	public void User_03_Dynamic_Page_01() {
		rewardPointPage = (UserRewardPointPageObejct) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");
		
		addressPage = (UserAddressPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Addresses");
		
		myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openPagesAtMyAccountByName(driver, "My product reviews");
		
		 
	}
	@Test
	public void User_03_Dynamic_Page_02() {
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		 
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
