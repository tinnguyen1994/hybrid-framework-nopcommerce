package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		this.driver= driver;
	}
	
	public void inputToUserNameTextBox(String emailAddress){
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	public void inputToPasswordTextBox(String password){
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public AdminMyDashboardObject openMyDashboardPage() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}
	public AdminMyDashboardObject loginAsAdmin(String emailAddress, String password) {
		inputToUserNameTextBox(emailAddress);
		inputToPasswordTextBox(password);
		return openMyDashboardPage();
	}
}
