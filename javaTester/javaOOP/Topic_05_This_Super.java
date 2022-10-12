package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Topic_05_This_Super extends BaseOOP {
	private WebDriver driver;
	private long longTimeout =45;
	
	
	public Topic_05_This_Super() {
		System.out.println("Contructor tại Class con");
	}
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}
	public void clickToElement() {
		setImplicitWait();
	}
	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super();
	}

}
