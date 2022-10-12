package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestLiveGuru {
	private WebDriver driver;
	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");

			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserName.equals("coc coc")) {
			WebDriverManager.chromedriver().driverVersion("102.0.5005.61").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("brave")) {
			WebDriverManager.chromedriver().driverVersion("102.0.5005.61").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/index.php/");
		return driver;
	}
	protected String getEvironmentUrl(String serverName) {
		String envUrl= null ;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		switch (environment) {
		case DEV:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case TESTING:
			envUrl = "https://admin-demo.nopcommerce.com";
			break;
		case STAGING:
			envUrl = "https://staging.nopcommerce.com";
			break;
		case PRE_PROD:
			envUrl = "https://pre_prod.nopcommerce.com";
			break;
		case PROD:
			envUrl = "https://prod.nopcommerce.com";
			break;

		default:
			envUrl = null;
			break;
		}
	
		return envUrl;
	}
	protected void sleepInSecond(long time) {
		try {
			Thread.sleep(1000 * time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
