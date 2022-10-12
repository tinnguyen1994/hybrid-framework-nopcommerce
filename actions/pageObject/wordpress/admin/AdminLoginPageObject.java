package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void enterToUserNameTextbox(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, adminUserName);
	}
	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, adminPassword);		
	}
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
		
	}
	public AdminDashboardPageObject loginAsDashboard(String adminUserName,String adminPassword) {
		enterToUserNameTextbox(adminUserName);
		enterToPasswordTextbox(adminPassword);
		return clickToLoginButton();
	}

}
