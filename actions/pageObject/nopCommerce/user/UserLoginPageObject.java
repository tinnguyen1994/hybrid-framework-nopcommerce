package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@Step("Click to Login button ")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Step("Verify Error message Email textbox")
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	@Step("Enter to Email textbox with value is")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	@Step("Verify Unsuccessfull Error Email")
	public String getUnsuccessfullErrorEmail() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFULLY_EMAIL_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESSFULLY_EMAIL_MESSAGE);
	}
	
	@Step("Enter to Password textbox with value is")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);		
	}
	
	public UserHomePageObject loginAsUser(String emailAddress,String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}





}
