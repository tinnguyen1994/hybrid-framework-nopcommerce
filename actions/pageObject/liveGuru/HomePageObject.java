package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public LoginPageObject clickToMyAccountLink() {
		
		clickToElementByJS(driver, HomePageUI.MYACCOUNTLINK);
		return PageGeneratorManagerLiveGuru.getLoginPage(driver);
	}

}
