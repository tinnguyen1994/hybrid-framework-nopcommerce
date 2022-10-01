package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageObject.wordpress.admin.UserPostDetailPageObject;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver= driver;
	}
	
	@Step("Navigate to Register page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	@Step("Navigate to Login page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, HomePageUI.lOGIN_LINK);
		clickToElement(driver, HomePageUI.lOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Verify My Account link to Displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	@Step("Navigate to CustomerInfo page")
	public UserCustomerInforPageObject openMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public boolean isPostInforDisplayed(String postTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserPostDetailPageObject clickToPostTitle() {
		// TODO Auto-generated method stub
		return null;
	}


}
