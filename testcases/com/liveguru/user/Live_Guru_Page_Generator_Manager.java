package com.liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.BaseTestLiveGuru;
import commons.GlobalConstands;
import pageObject.liveGuru.AccountInforPageObject;
import pageObject.liveGuru.AdminPageObject;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.ManageCustomerPageObject;
import pageObject.liveGuru.MyDashboardPageObject;
import pageObject.liveGuru.MyOrdersPageObject;
import pageObject.liveGuru.PageGeneratorManagerLiveGuru;
import pageObject.liveGuru.RegisterPageObject;
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;

public class Live_Guru_Page_Generator_Manager extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage ;
	private LoginPageObject loginPage;
	private MyDashboardPageObject myDashboardPage;
	private String firstName, lastName, emailAdress, password,userNameAdmin,passwordAdmin;
	private pageObject.liveGuru.MyProductReviewPageObject myProductReviewPage;
	private AccountInforPageObject addressInforPage;
	private MyOrdersPageObject myOrdersPage;
	private AdminPageObject adminLoginPage;
	private ManageCustomerPageObject managerCustomerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManagerLiveGuru.getHomePage(driver);
		
		
		firstName = "Tin";
		lastName = "Nguyen";
		emailAdress = "automationFC" + generaFakeNumber() +"@gmail.com";
		password ="123456" ;
		userNameAdmin="user01";
		passwordAdmin="guru99com";
				
		
	}
	@Test
	public void User_01_Register_To_System() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccount();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAdress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		myDashboardPage = registerPage.clickToRegisterButton();
		
		Assert.assertEquals(myDashboardPage.getRegisterEmailSuccessMessage(), "Thank you for registering with Main Website Store.");
		homePage= myDashboardPage.clickToLogoutLink();
		
	}
	@Test
	public void User_02_Login_To_System() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputToEmailTextBox(emailAdress);
		loginPage.inputToPasswordTextBox(password);
		myDashboardPage = loginPage.clickToLoginButton();
		
	}
	@Test
	public void User_03_Switch_Page() {
		addressInforPage= myDashboardPage.openAddressInfoPage(driver);
		
		myOrdersPage = addressInforPage.openMyOrdersPage(driver);
		
		myProductReviewPage = myOrdersPage.openMyProductReviewPageLive(driver);
		
		addressInforPage = myProductReviewPage.openAddressInfoPage(driver);
		addressInforPage.openPageUrl(driver, GlobalConstands.LIVE_GURU_ADMIN);
//		adminLoginPage = PageGeneratorManagerLiveGuru.getAdminLoginPage(driver);
//		managerCustomerPage = adminLoginPage.loginAsAdmin(userNameAdmin, passwordAdmin);
//		managerCustomerPage.closePopUp();
//		managerCustomerPage.checkToCheckBoxAtColumn("4","1");
//		managerCustomerPage.selectToOptionText("Delete");
//		managerCustomerPage.clickToSubmitButton();

	}
	@Test
	public void Delete_Row() {
		//addressInforPage.openPageUrl(driver, GlobalConstands.LIVE_GURU_ADMIN);
		adminLoginPage= PageGeneratorManagerLiveGuru.getAdminLoginPage(driver);

		managerCustomerPage = adminLoginPage.loginAsAdmin(userNameAdmin, passwordAdmin);
		managerCustomerPage= adminLoginPage.openManageCustomerPage(driver);
		managerCustomerPage.checkToCheckBoxAtColumn("4","1");
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	public int generaFakeNumber() {
		Random rand = new Random();
		return rand.nextInt();
	}
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(1000 * time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
