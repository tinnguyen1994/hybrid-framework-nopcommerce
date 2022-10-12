package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {

	WebDriver driver;
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public AdminPostsSearchPageObject clickToPostsMenuLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.POSTS_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.POSTS_MENU_LINK);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
		
	}

}
