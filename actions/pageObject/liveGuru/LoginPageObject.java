package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public RegisterPageObject clickToCreateAnAccount() {
		waitForElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManagerLiveGuru.getRegisterPage(driver);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToEmailTextBox(String emailAdress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTB0X);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTB0X, emailAdress);
	}

	public MyDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerLiveGuru.getMyDashboardPage(driver);
	}

}
