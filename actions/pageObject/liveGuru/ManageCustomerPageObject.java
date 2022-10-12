package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.ManageCustomerUI;

public class ManageCustomerPageObject extends BasePage {
	private WebDriver driver;

	public ManageCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopUp() {
		waitForElementClickable(driver, ManageCustomerUI.CLOSE_POPUP);
		clickToElement(driver, ManageCustomerUI.CLOSE_POPUP);
	}

	public void checkToCheckBoxAtColumn(String rowNumber, String columnNumber) {
		waitForElementClickable(driver, ManageCustomerUI.CHECK_TO_CHECKBOX_AT_ROW_NUMBER, rowNumber,columnNumber);
		checkToDefaultCheckboxOrRadioButton(driver, ManageCustomerUI.CHECK_TO_CHECKBOX_AT_ROW_NUMBER, rowNumber,columnNumber);
	}

	public void selectToOptionText(String textOption) {
		waitForElementClickable(driver, ManageCustomerUI.SELECT_TO_OPTION, textOption);
		selectItemInDefaultDropdown(driver, ManageCustomerUI.SELECT_TO_OPTION, textOption);
	}

	public void clickToSubmitButton() {
		
	}
	
}
