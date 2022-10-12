package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostsAddNewPageObject extends BasePage {
	
		WebDriver driver;
		public AdminPostsAddNewPageObject(WebDriver driver) {
			this.driver=driver;
		}
		public void enterToAddNewPostTitle(String postTitle) {
			waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
			sendkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitle);
		}
		public void enterToAddNewPostBody(String postBody) {
			waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_BUTTON);
			clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
			
			
			waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
			
			sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBody);
		}
		public void clickToPublishOrUpdateButton() {
			waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
			clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
			
			waitForElementClickable(driver, AdminPostAddNewPageUI.RE_PUBLISH_BUTTON);
			clickToElement(driver, AdminPostAddNewPageUI.RE_PUBLISH_BUTTON);
		}
		public AdminPostsSearchPageObject openSearchPostPageUrl(String searchPostUrl) {
			openPageUrl(driver, searchPostUrl);
			return PageGeneratorManager.getAdminPostSearchPage(driver);
		}
		public boolean isPostPublishedMessageDisplayed(String postPublishedMessage) {
			waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_MESSAGE, postPublishedMessage);
			return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_MESSAGE, postPublishedMessage);
		}
		public void enterToEditPostBody(String editBody) {
			waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
			clickToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
			
			waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
			clearElementByDeleteKey(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
			sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, editBody);
		}
		public void clickToUpdateButton() {
			waitForElementClickable(driver, AdminPostAddNewPageUI.UPDATE_BUTTON);
			clickToElement(driver, AdminPostAddNewPageUI.UPDATE_BUTTON);
		}
}
