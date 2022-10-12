package javaOOP.Exception;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThrowAndThrows {
	WebDriver driver;
	
	@Test
	public void TC_01_Frame() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("automation");
		driver.findElement(By.xpath("//a[contains(@class,'login-btn')]")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='fldPasswordDispId']")).isDisplayed());
	}
	
}
