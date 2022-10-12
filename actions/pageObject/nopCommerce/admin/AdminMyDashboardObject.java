package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminMyDashboardUI;

public class AdminMyDashboardObject extends BasePage {
	private WebDriver driver;

	public AdminMyDashboardObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyDashboardHeaderDisplay() {
		waitForElementVisible(driver, AdminMyDashboardUI.MYDASHBOARD_HEADER_DISPLAY);
		return isElementDisplayed(driver, AdminMyDashboardUI.MYDASHBOARD_HEADER_DISPLAY);
	}

}
