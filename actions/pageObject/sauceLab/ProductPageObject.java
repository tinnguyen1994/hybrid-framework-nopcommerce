package pageObject.sauceLab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_SORT_CONTAINER);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_SORT_CONTAINER, textItem);
	}

	public boolean isProductNameSortByAscending() {
		ArrayList<String> productUIList = new ArrayList<String>();
		
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("Product trên UI : " + productUIList);
		}
		
		ArrayList<String> productSortList = new ArrayList<String>();
		
		for (String product : productUIList) {
			productSortList.add(product);
		}
		
		Collections.sort(productSortList);
		for (String productName : productSortList) {
			System.out.println("Product sau khi Sort ASC : " + productName);
		}
		
		
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		ArrayList<String> productUIList = new ArrayList<String>();
		
		List<WebElement> prouctNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		for (WebElement productName : prouctNameText) {
			productUIList.add(productName.getText());
			System.out.println("Product name trên UI : " + productUIList);
		}
		
		ArrayList<String> productSortName = new ArrayList<String>();
		
		for (String product : productUIList) {
			productSortName.add(product);
			System.out.println("Product sau khi sort DESC : " + productUIList );

		}
		Collections.sort(productSortName);
		for (String productName : productSortName) {
			System.out.println("Product sau khi sort ASC : " + productName );
		}
		Collections.reverse(productSortName);
		for (String productName : productSortName) {
			System.out.println("Product sau khi sort DESC : " + productName );
		}
		
		return productSortName.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();

		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "").trim()));
			System.out.println("Product Price trên UI : " + productPrice.getText());
			
		}
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		for (Float productName : productSortList) {

			System.out.println("Product Price sau khi Sort ASC :" + productName);
		}

		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();

		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "").trim()));
			System.out.println("Product Price trên UI : " + productPrice.getText());
			
		}
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		for (Float productName : productSortList) {

			System.out.println("Product Price sau khi Sort ASC :" + productName);
		}
		Collections.reverse(productSortList);
		
		for (Float productName : productSortList) {

			System.out.println("Product Price sau khi Sort DESC :" + productName);
		}
		return productSortList.equals(productUIList);
	}
}
