package pageUIs.wordpress.admin;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON="css=a.page-title-action";
	public static final String SEARCH_TEXTBOX="css=#post-search-input";
	public static final String SEARCH_POSTS_BUTTON="css=#search-submit";
	
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME="xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME_TEXT="xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']";
	public static final String TABLE_ROW_INDEX_BY_HEADER_INDEX="xpath=//table[contains(@class,'table-view-list posts')]/tbody//tr/*[%s]";
	public static final String EDIT_TABLE_ROW_INDEX_BY_HEADER_INDEX="xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE_NAME="xpath=//table[contains(@class,'table-view-list posts')]/tbody//th/label[contains(text(),'%s')]/following-sibling::input";
	public static final String ACTIONS_DROPDOWN="css=select#bulk-action-selector-top";
	public static final String APPLY_BUTTON="css=input#doaction";
	public static final String MOVE_TO_TRASH_MESSAGE ="xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String NO_POST_FOUND_MESSAGE ="xpath=//table[contains(@class,'table-view-list posts')]//tr[@class='no-items']/td[text()='%s']";
	
	
}
