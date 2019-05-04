package listeners;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class AutomationDriver {

	private static WebDriver driver;

	public static void setDriver(WebDriver driver) {
		AutomationDriver.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	@Parameters({ "browser" })
	public void setUp(String browserType) {
		if ("IExplorer".equalsIgnoreCase(browserType)) {
			System.setProperty("webdriver.ie.driver",
					"F:\\Projects\\TestNG_Practice\\src\\main\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if ("Chrome".equalsIgnoreCase(browserType)) {
			System.setProperty("webdriver.chrome.driver",
					"F:\\Projects\\TestNG_Practice\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(createAutomatableDriver());
		}
		setDriver(driver);
		driver.get("chrome://version/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	private ChromeOptions createAutomatableDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("-start-maximized");
		chromeOptions.addArguments("--disable-infobars");
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return chromeOptions;
	}
	
	@AfterSuite
	public void cleanUp() throws IOException {
		driver.close();
		driver.quit();
		Runtime.getRuntime().exec(new String[] {"cmd", "/K", "TASKKILL /IM chromedriver.exe /F"}); 
	}

}
