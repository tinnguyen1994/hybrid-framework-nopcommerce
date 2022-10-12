package pageObject.sauceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sauceLab.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public  LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void inputToUserNameTextbox(String userName) {
		waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, userName);
	}
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public ProductPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneretorManager_SauceLab.getProductPage(driver);
	}
	public ProductPageObject loginAsProductPage(String userName,String password) {
		inputToUserNameTextbox(userName);
		inputToPasswordTextbox(password);
		return clickToLoginButton()	;
	}
}
