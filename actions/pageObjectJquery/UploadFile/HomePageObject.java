package pageObjectJquery.UploadFile;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import commons.BasePage;
import pageUIs.Jquery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	protected HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.Jquery.uploadFile.HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, pageUIs.Jquery.uploadFile.HomePageUI.FILE_NAME_LOADED, fileName);
	}
	public boolean isFileUpLinkLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.Jquery.uploadFile.HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, pageUIs.Jquery.uploadFile.HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}
	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, pageUIs.Jquery.uploadFile.HomePageUI.BUTTON_START);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	
	
	}
	public boolean isFileUpImageLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.Jquery.uploadFile.HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, pageUIs.Jquery.uploadFile.HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);		 
	}

	
	
}
