package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageUIs.wordpress.admin.AdminPostSearchPageUI;

public class AdminPostsSearchPageObject extends BasePage {

	WebDriver driver;

	public AdminPostsSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostsAddNewPageObject clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForAllElementsVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchPostButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		sleepInSecond(2);
	}

	public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
		// int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME_TEXT, headerID);
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME_TEXT, headerID, cellValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME_TEXT, headerID, cellValue);
	}

	public AdminPostsAddNewPageObject clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.EDIT_TABLE_ROW_INDEX_BY_HEADER_INDEX, postTitle);
		sleepInSecond(2);
		clickToElement(driver, AdminPostSearchPageUI.EDIT_TABLE_ROW_INDEX_BY_HEADER_INDEX, postTitle);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void selectPostCheckBoxByTitle(String editTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editTitle);
		checkToDefaultCheckboxOrRadioButton(driver,  AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editTitle);
	}

	public void selectTextItemActionDropdown(String dropdownItem) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ACTIONS_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTIONS_DROPDOWN, dropdownItem);
		
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);

	}

	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForAllElementsVisible(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isNoPostsFoundMessageDisplayed(String message) {
		waitForAllElementsVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
	}

}
