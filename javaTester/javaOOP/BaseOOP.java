package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseOOP {
	protected long longTimeout =45;
	private WebDriver driver;
	
	public BaseOOP(String name) {
		System.out.println("Contructor tại Class cha 2");
	}
	public BaseOOP() {
		System.out.println("Contructor tại Class cha");
	}
	public BaseOOP(int number) {
		System.out.println("Contructor tại Class cha 3");
	}
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}
}
