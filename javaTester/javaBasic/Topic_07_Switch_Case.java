package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	@Parameters("browser")
	public void switchCase(String browserName) {
		
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		
		case "egde":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default :
			new RuntimeException("Please input correct the browser name");
			break;
		}
	}
	public void TC_02() {
		int month = scanner.nextInt();
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12	:
			System.out.println("This month has 31 days");
			break ;
		case 2:
			System.out.println("This month has 28 days");
			break ;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("This month has 30 days");
			break ;
		default:
			System.out.println("please re-enter");
			
		}
	}
	public void TC_03() {
		int number = scanner.nextInt();
		
		switch (number) {

		case 1:
			System.out.println("One");
			break ;
		case 2:
			System.out.println("Two");
			break ;
		case 3:
			System.out.println("Three");
			break ;
		case 4:
			System.out.println("Four");
			break ;
		case 5:
			System.out.println("Five");
			break ;
		case 6:
			System.out.println("Six");
			break ;
		case 7:
			System.out.println("Seven");
			break ;	
		case 8	:
			System.out.println("Eight");
			break ;
		case 9:
			System.out.println("Nine");
			break ;
		case 10:
			System.out.println("Ten");
			break ;
		default:
			System.out.println("please re-enter");
			
		}
	}
	@Test
	public void TC_04() {
		
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		
		case "+":
			System.out.println("A + B = " + (numberA +  numberB));
			break;
		case "-":
			System.out.println("A - B = " + (numberA -  numberB));
			break;
		case "*":
			System.out.println("A * B = " + (numberA *  numberB));
			break;
		case "/":
			System.out.println("A / B = " + (numberA /  numberB));
			break;
		case "%":
			System.out.println("A % B = " + (numberA %  numberB));
			break;
		default:
			break;
		}
	}
}
