package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterEmailSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_MESSAGE_SUCCESS);
		return getElementText(driver, MyDashboardPageUI.REGISTER_MESSAGE_SUCCESS);
	}

	public HomePageObject clickToLogoutLink() {
		clickToElementByJS(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManagerLiveGuru.getHomePage(driver);
	}


}
