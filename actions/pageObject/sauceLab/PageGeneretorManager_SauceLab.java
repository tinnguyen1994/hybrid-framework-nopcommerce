package pageObject.sauceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneretorManager_SauceLab extends BasePage {
	WebDriver driver;
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
}
