package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}
	public boolean isPostInforDisplayedWithPostBody(String postTitle,String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle,postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle,postBody);
	}
	public boolean isPostInforDisplayedWithPostAuthorName(String postTitle,String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle,authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle,authorName);
	}
	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle,String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle,currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle,currentDay);
	}
	public UserPostDetailPageObject clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT,postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT,postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}
	public boolean isPostInforUnDisplayedWithPostTitle(String editTitle) {
		return isElementUnDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editTitle);
		
	}
	public void enterToSearchTextBox(String editTitle) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX,editTitle);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX,editTitle);
	}
	public UserSearchPostPageObject clickToSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchPostPage(driver);
	}

}
