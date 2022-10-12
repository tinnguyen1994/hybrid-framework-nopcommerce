package commons;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.admin.AdminMyDashboardObject;
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointPageObejct;

public class PageGeneratorManager extends BasePage {
	WebDriver driver;
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	
	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}
	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	public static UserRewardPointPageObejct getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObejct(driver);
	}	
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminMyDashboardObject getMyDashboardPage(WebDriver driver) {
		return new AdminMyDashboardObject(driver);
	}
}
