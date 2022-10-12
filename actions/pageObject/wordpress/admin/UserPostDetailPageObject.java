package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.UserHomePageUI;
import pageUIs.wordpress.admin.UserPostDetailPageUI;

public class UserPostDetailPageObject extends BasePage {
	private WebDriver driver;
	
	public UserPostDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
	}
	public boolean isPostInforDisplayedWithPostBody(String postTitle,String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle,postBody);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle,postBody);
	}
	public boolean isPostInforDisplayedWithPostAuthorName(String postTitle,String authorName) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle,authorName);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle,authorName);
	}
	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle,String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle,currentDay);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle,currentDay);
	}

}
