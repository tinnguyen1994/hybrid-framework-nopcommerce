package pageUIs.wordpress.admin;

public class UserHomePageUI {
	public static final String POST_TITLE_TEXT="xpath=//header//a[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE="xpath= //article//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String POST_CURRENT_DAY_TEXT_BY_POST_TITLE="xpath=//article//a[text()='%s']/parent::h2//following-sibling::div//time[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE="xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//span[@class='author vcard']/a[text()='%s']";
	public static final String SEARCH_TEXTBOX="xpath=//div[@class='wp-block-search__inside-wrapper ']//input[@type='search']";
	public static final String SEARCH_BUTTON="xpath=//div[@class='wp-block-search__inside-wrapper ']//button[@type='submit']";
}
 