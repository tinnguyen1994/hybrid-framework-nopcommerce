package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.user.UserAddressPageObject;


public class PageGeneratorManagerLiveGuru {
	WebDriver driver;
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}
	public static MyProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	public static AccountInforPageObject getAddressPage(WebDriver driver) {
		return new AccountInforPageObject(driver);
	}
	public static MyOrdersPageObject getMyOrdersPage(WebDriver driver) {
		return new MyOrdersPageObject(driver);
	}
	public static AdminPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminPageObject(driver);
	}
	public static ManageCustomerPageObject getManageCustomerPage(WebDriver driver) {
		return new ManageCustomerPageObject(driver);
	}
}
