package com.wordpress.posts;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserCustomerInforPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointPageObejct;
import pageObject.wordpress.admin.AdminDashboardPageObject;
import pageObject.wordpress.admin.AdminLoginPageObject;
import pageObject.wordpress.admin.AdminPostsAddNewPageObject;
import pageObject.wordpress.admin.AdminPostsSearchPageObject;
import pageObject.wordpress.admin.UserPostDetailPageObject;
import pageObject.wordpress.admin.UserSearchPostPageObject;
import reportConfig.ExtentManager;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	
	String adminUserName = "automationfc";
	String adminPassword = "tinnguyen";
	
	String searchPostUrl;
	int randomNumber = generakeFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber ;
	String postBody = "Live Coding Body " + randomNumber;
	String editTitle = "Edit Coding Body " + randomNumber;
	String editBody = "Edit Coding Body " + randomNumber;
	String authorName ="automationfc";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();

	@Parameters({"browser","urlAdmin","urlUser"})
	@BeforeClass
	public void beforeClass(String browserName,String adminUrl,String enduserUrl) {
		log.info("Pre-Condition - Step 01 : Open browser and admin Url");
		this.adminUrl=adminUrl;
		this.endUserUrl=enduserUrl;
		driver = getBrowserDriver(browserName,this.adminUrl);
		adminLoginPage = pageObject.wordpress.admin.PageGeneratorManager.getAdminLoginPage(driver);
		
//		log.info("Pre-Condition - Step 02 :Enter to Username textbox with value :" + adminUserName);
//		adminLoginPage.enterToUserNameTextbox(adminUserName);
//		
//		log.info("Pre-Condition - Step 03 :Enter to Password textbox with value : " + adminPassword);
//		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		
		
//		log.info("Pre-Condition - Step 04 : Click to Login button");
//		adminLoginPage.clickToLoginButton();
		
		adminDashboardPage = adminLoginPage.loginAsDashboard(adminUserName, adminPassword);
		
		




	}
	
	@Description("Create New Post")
	@Severity(SeverityLevel.NORMAL)	
	@Test
	public void Post_01_Create_New_Post(Method method) {

		log.info("Create_Post - Step 01 : Click to 'Posts' link menu ");
		adminPostSearchPage= adminDashboardPage.clickToPostsMenuLink();
		
		log.info("Create_Post - Step 02 : Click to Add new button ");
		searchPostUrl=adminPostSearchPage.getPageUrl(driver);
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create_Post - Step 03 : Enter to Post title ");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		log.info("Create_Post - Step 04 : Enter to body ");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);

		log.info("Create_Post - Step 04 : Click to Publish button ");
		adminPostAddNewPage.clickToPublishOrUpdateButton();
		log.info("Create_Post - Step 04 : Verify 'Post published ' message is displayed ");
		verifyTrue(adminPostAddNewPage.isPostPublishedMessageDisplayed("Post published."));
		

	}
	
	@Description("Open to search Post page")
	@Severity(SeverityLevel.NORMAL)	
	@Test
	public void Post_02_Serch_Post(Method method) {
		log.info("Search_Post - Step 01 : Open to 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Search_Post - Step 02 : Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Search_Post - Step 03 : Click to search posts button");
		adminPostSearchPage.clickToSearchPostButton();
		
		
		log.info("Search_Post - Step 04 : Verify search table contains " + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));
		
		log.info("Search_Post - Step 05 : Verify search table contains " + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		log.info("Search_Post - Step 06 : Open End user site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver,this.endUserUrl);
		
		log.info("Search_Post - Step 07 : Verify Post info displayed at Home page ");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle,postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthorName(postTitle,authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle,currentDay));
		sleepInSecond(3);
		
		
		log.info("Search_Post - Step 08 : Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		sleepInSecond(2);

		log.info("Search_Post - Step 09 : Verify Post infor displayed at Post detail page ");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle,postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthorName(postTitle,authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(postTitle,currentDay));
		sleepInSecond(3);

		
	}
	@Test
	public void Post_03_View_Post(Method method) {
		log.info("Edit_Post - Step 01 : Open Admin site");
		adminDashboardPage = userHomePage.openAdimSite(driver,this.adminUrl);
		
		log.info("Edit_Post - Step 02 : Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostsMenuLink();
		
		log.info("Edit_Post - Step 03 : Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Edit_Post - Step 04 : Click to search posts button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Edit_Post - Step 05 : Click to Post title link ");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);
		
		log.info("Edit_Post - Step 06 : Enter to Post title ");
		adminPostAddNewPage.enterToAddNewPostTitle(editTitle);
		
		log.info("Edit_Post - Step 07 : Enter to body ");
		adminPostAddNewPage.enterToEditPostBody(editBody);
		
		log.info("Edit_Post - Step 08 : Click to 'Update' button ");
		adminPostAddNewPage.clickToUpdateButton();
		
		log.info("Edit_Post - Step 09 : Verify 'Post updated ' message is displayed ");
		verifyTrue(adminPostAddNewPage.isPostPublishedMessageDisplayed("Post updated."));
		
		log.info("Edit_Post - Step 10 : Open to 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Edit_Post - Step 11 : Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);
		
		log.info("Edit_Post - Step 12 : Click to search posts button");
		adminPostSearchPage.clickToSearchPostButton();
		
		
		log.info("Edit_Post - Step 13 : Verify search table contains " + editBody + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editBody));
		
		log.info("Edit_Post - Step 14 : Verify search table contains " + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		log.info("Edit_Post - Step 15 : Open End user site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver,this.endUserUrl);
		
		log.info("Edit_Post - Step 16 : Verify Post info displayed at Home page ");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editTitle,editBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthorName(editTitle,authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(editTitle,currentDay));
		sleepInSecond(3);
		
		
		log.info("Edit_Post - Step 17 : Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editTitle);
		sleepInSecond(2);

		log.info("Edit_Post - Step 18 : Verify Post infor displayed at Post detail page ");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editTitle,editBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthorName(editTitle,authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(editTitle,currentDay));
		sleepInSecond(3);
	}
	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01 : Open Admin site");
		adminDashboardPage = userHomePage.openAdimSite(driver,this.adminUrl);
		
		log.info("Delete_Post - Step 02 : Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostsMenuLink();
		
		log.info("Delete_Post - Step 03 : Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);
		
		log.info("Delete_Post - Step 04 : Click to search posts button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Delete_Post - Step 05 : Select Post detail checkbox");
		adminPostSearchPage.selectPostCheckBoxByTitle(editTitle);
		
		log.info("Delete_Post - Step 06 : Select 'Move to trash' item in dropdown");
		adminPostSearchPage.selectTextItemActionDropdown("Move to Trash");
		
		log.info("Delete_Post - Step 07 : Click to Apply button");
		adminPostSearchPage.clickToApplyButton();
		
		log.info("Delete_Post - Step 08 : Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));
		
		log.info("Delete_Post - Step 09 : Enter to 'Search' textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);
		
		log.info("Delete_Post - Step 10 : Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Delete_Post - Step 11 : Verify 'No posts found.' message is displayed");
		verifyTrue(adminPostSearchPage.isNoPostsFoundMessageDisplayed("No posts found."));
		
			
		log.info("Delete_Post - Step 12 : Open End User site");
		userHomePage= adminPostAddNewPage.openEndUserSite(driver, this.endUserUrl);
		
		log.info("Delete_Post - Step 13 : Verify Post title undisplayed at Home Page");
		verifyTrue(userHomePage.isPostInforUnDisplayedWithPostTitle(editTitle));

		
		log.info("Delete_Post - Step 14 : Enter to 'Search' textbox");
		userHomePage.enterToSearchTextBox(editTitle);
		
		log.info("Delete_Post - Step 15 : Click to Search button");
		userSearchPostPage = userHomePage.clickToSearchButton();
		
		log.info("Delete_Post - Step 16 : Verify 'Nothing Found' message displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));

		
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int generakeFakeNumber() {
		Random rand = new Random();
		return rand.nextInt();
	}
	private WebDriver driver;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminPostsSearchPageObject adminPostSearchPage;
	private AdminPostsAddNewPageObject adminPostAddNewPage;
	private UserPostDetailPageObject userPostDetailPage;
	private UserSearchPostPageObject userSearchPostPage;
	private pageObject.wordpress.admin.UserHomePageObject userHomePage;
}
