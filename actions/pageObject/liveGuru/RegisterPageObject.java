package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTB0X);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTB0X, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTB0X);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTB0X, lastName);		
	}

	public void inputToEmailTextBox(String emailAdress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTB0X);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTB0X, emailAdress);		
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTB0X);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTB0X, password);		
	}

	public void inputToConfirmPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTB0X);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTB0X, password);		
	}

	public MyDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManagerLiveGuru.getMyDashboardPage(driver);
	}

	public AdminPageObject openAdminPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
