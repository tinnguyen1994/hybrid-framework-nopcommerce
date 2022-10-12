package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.UserHomePageUI;
import pageUIs.wordpress.admin.UserPostDetailPageUI;
import pageUIs.wordpress.admin.UserPostSearchPageUI;

public class UserSearchPostPageObject extends BasePage {
	private WebDriver driver;
	
	public UserSearchPostPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, UserPostSearchPageUI.NOTHING_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, UserPostSearchPageUI.NOTHING_FOUND_MESSAGE, message);
	}


}
