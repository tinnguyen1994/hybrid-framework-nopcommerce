package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.AdminPageUI;

public class AdminPageObject extends BasePage {
	private WebDriver driver;
	public AdminPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToUserNameTextBox(String userNameAdmin) {
		waitForElementVisible(driver, AdminPageUI.USER_NAME_ADMIN);
		sendkeyToElement(driver, AdminPageUI.USER_NAME_ADMIN, userNameAdmin);
	}
	
	public void inputToPasswordTextBox(String passwordAdmin) {
		waitForElementVisible(driver, AdminPageUI.PASSWORD_ADMIN);
		sendkeyToElement(driver, AdminPageUI.PASSWORD_ADMIN, passwordAdmin);
	}
	public ManageCustomerPageObject openManageCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerLiveGuru.getManageCustomerPage(driver);
	}
	public ManageCustomerPageObject loginAsAdmin(String userNameAdmin,String passwordAdmin) {
		inputToUserNameTextBox(userNameAdmin);
		inputToPasswordTextBox(passwordAdmin);
		return openManageCustomerPage(driver);
		
	}
}
