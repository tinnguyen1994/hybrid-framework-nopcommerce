package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String ADDRESS_LINK="XPATH=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK="xpath=//div[contains(@class,'block-account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK="xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Reward points']";
	public static final String LOGUOUT_LINK_AT_USER_PAGE="css=a[class='ico-logout']";
	public static final String LOGUOUT_LINK_AT_ADMIN_PAGE="xpath=//a[text()='Logout']";
	public static final String INVISIPLE_LINK_AT_MYDASHBOARD="xpath=//div[@id='ajaxBusy']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA="xpath=//div[contains(@class,'block-account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID="xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT="xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME="xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL="xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL="xpath=//label[contains(text(),'%s')]/following-sibling::input";
	

}
