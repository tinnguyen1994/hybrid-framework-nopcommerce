package javaOOP.Exception;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleException {
	FirefoxDriver driver;
	WebDriverWait explicitWait;
	

	public void TC_01() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://live.techpanda.org/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']")).click();;
	}
	@Test
	public void TC_02() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_ContentPlaceholder1_Panel1']")));
		
		WebElement dataNotSelected = driver.findElement(By.xpath("//span[@class='label']"));
		Assert.assertEquals("No Selected Dates to display.", dataNotSelected.getText().trim());
		WebElement today = driver.findElement(By.xpath("//a[text()='2']"));
		today.click();
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='rcSelected']//a[text()='2']")));
		
	
	
	}
}
