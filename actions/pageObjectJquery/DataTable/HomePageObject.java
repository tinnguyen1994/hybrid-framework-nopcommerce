package pageObjectJquery.DataTable;

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

	public void openPagingByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxbyLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
			int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
			System.out.println("Total pages:" + totalPage);
			
			List<String> allRowEachPage = new ArrayList<String>();
			
			for (int index = 1; index <= totalPage; index++) {
				clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));	
				
				List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
				for (WebElement eachRow : allRowElementEachPage) {
					allRowEachPage.add(eachRow.getText());
				}
				for (String value : allRowEachPage) {
					System.out.println(value);
				}
			}return allRowEachPage;
		}
	public void clickToIconFooter(String addButton) {
		waitForElementClickable(driver, HomePageUI.ICON_FOOTER_BUTTON, addButton);
		clickToElement(driver, HomePageUI.ICON_FOOTER_BUTTON, addButton);

	}
	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
	}

	public void checkToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKB0X_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadioButton(driver, HomePageUI.CHECKB0X_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKB0X_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		uncheckToDefaultCheckboxButton(driver, HomePageUI.CHECKB0X_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER,rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER,rowNumber, iconName);
	}

	
}
