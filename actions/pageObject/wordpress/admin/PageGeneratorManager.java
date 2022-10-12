package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager extends BasePage {
	WebDriver driver;
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	public static AdminPostsAddNewPageObject getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostsAddNewPageObject(driver);
	}
	public static AdminPostsSearchPageObject getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostsSearchPageObject(driver);
	}
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserPostDetailPageObject getUserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPageObject(driver);
	}
	
	public static UserSearchPostPageObject getUserSearchPostPage(WebDriver driver) {
		return new UserSearchPostPageObject(driver);
	}
}
