package javaBasic;

public class Topic13_StringFormat {
	public static String ADDRESS_LINK="XPATH=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
	public static String MY_PRODUCT_REVIEW_LINK="xpath=//div[contains(@class,'block-account-navigation')]//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK="xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Reward points']";
	
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME="//div[contains(@class,'block-account-navigation')]//a[text()='%s']";
	public static String DYNAMIC_LINK_BY_PAGE_NAME="//div[contains(@class,'%s')]//a[text()='%s']";

	
	public static void main(String[] args) {
//		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Addresses");
//		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "My product reviews");
//		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Reward points");
		
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "block-account-navigation", "Addresses");
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "block-account-navigation", "My product reviews");
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "block-account-navigation", "Reward points");
	}
	public static void clickToSideBarLink(String locator) {
		System.out.println("Click to :" + locator);
	}
	//1 tham số
	
//	public static void clickToLink(String dynamicLocator, String pageName) {
//		String locator = String.format(dynamicLocator, pageName);
//		System.out.println("Click to :"+ locator);
//	}
//	public static void clickToLink(String dynamicLocator, String pageName) {
//		String locator = String.format(dynamicLocator, pageName);
//		System.out.println("Click to :"+ locator);
//	}
//	public static void clickToSideBarLink(String dynamicLocator,String areaName ,String pageName) {
//		String locator = String.format(dynamicLocator, areaName,pageName);
//		System.out.println("Click to :"+ locator);
//	}
	public static void clickToSideBarLink(String dynamicLocator,String...params) {
		String locator = String.format(dynamicLocator,(Object[]) params);
		System.out.println("Click to :"+ locator);
	}
}
