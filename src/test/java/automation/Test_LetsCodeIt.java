package automation;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import listeners.AutomationDriver;
import listeners.ScreenshotListener;

@Listeners(ScreenshotListener.class)
public class Test_LetsCodeIt {

	WebDriver driver;
	String baseURL;

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browserType) {
		this.baseURL = "https://www.google.com/intl/en-GB/gmail/about/#";
		if ("IExplorer".equalsIgnoreCase(browserType)) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\E076585\\Learning\\testng\\src\\main\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if ("Chrome".equalsIgnoreCase(browserType)) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\E076585\\Learning\\testng\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		AutomationDriver.setDriver(driver);
		driver.get("chrome://version/");
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	@Parameters({ "browser" })
	public void login(String browser) {
		Reporter.log("Locating the element with locator [" + "(//a[contains(text(),'Sign in')])[2]" + "]", true);
		WebElement singInLink = driver.findElement(By.xpath("(//a[contains(text(),'Sign in')])[2]"));
		singInLink.click();
	}

	@Test(priority = 2)
	public void focusOnNewTab() {
		Set<String> chromeTabs = driver.getWindowHandles();
		for (String chromeTabName : chromeTabs) {
			System.out.println("Chrome Tab Name is " + chromeTabName);
			driver.switchTo().window(chromeTabName);
		}		
	}

	@Test(priority = 3)
	public void enterFields() {
		Reporter.log("Locating the element with locator [" + "identifierId" + "]", true);
		WebElement emailField = driver.findElement(By.cssSelector("#identifierId"));
		emailField.sendKeys("letskodeit@gmail.com");
		Reporter.log("Locating the element with locator [" + "//*[@id=\"identifierNext\"]/content/span" + "]", true);
		WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span"));
		nextButton.click();		
		Reporter.log("Locating the element with locator [" + "//*[@id=\"password\"]/div[1]/div/div[1]/input" + "]", true);
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
		passwordField.sendKeys("strongestavenger");
	}

	@Test(priority = 4)
	public void loginToApplication() {
		Reporter.log("Locating the element with locator [" + "//*[@id=\"passwordNext\"]/div[2]" + "]", true);
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='passwordNext']/div[2]"));
		loginButton.click();
	}

	@AfterClass
	public void cleanUp() {
		driver.close();
		driver.quit();
	}

}
