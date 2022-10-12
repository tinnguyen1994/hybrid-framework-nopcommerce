package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstands;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.admin.AdminMyDashboardObject;
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointPageObejct;

@Test
public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userEmailAddress, userPassword,adminEmailAddress,adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminMyDashboardObject adminMyDashboardPage;
	private UserCustomerInforPageObject	userCustomerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "tranlong1212@gmail.com";
		userPassword = "123456";
		adminEmailAddress="admin@yourstore.com";
		adminPassword="admin";
	}

	
	public void Role_01_User() {
		userLoginPage = userHomePage.openLoginPage();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		userCustomerInfoPage = userHomePage.openMyAccountLink();
		
		userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);
		
		userHomePage.openPageUrl(driver, GlobalConstands.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminMyDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		
		Assert.assertTrue(adminMyDashboardPage.isMyDashboardHeaderDisplay());
		adminLoginPage = adminMyDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}
		
	
	@Test
	public void Role_02_Admin() {
		adminLoginPage.openPageUrl(driver, GlobalConstands.PORTAL_PAGE_URL);
		sleepInSecond(2);
		userHomePage= PageGeneratorManager.getUserHomePage(driver);
		sleepInSecond(2);

		userLoginPage = userHomePage.openLoginPage();
		sleepInSecond(2);

		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

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
