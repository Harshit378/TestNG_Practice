package automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.AutomationDriver;
import listeners.ScreenshotListener;

@Component
@Listeners(ScreenshotListener.class)
public class Test_LetsCodeIt {

	WebDriver driver;
	String baseURL = "https://www.google.com/intl/en-GB/gmail/about/#";

	@BeforeClass
	public void launchAUT() {
		AutomationDriver.getDriver().get(baseURL);
	}
	
	@Test(priority = 1)
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
	public void loginToApplication() throws InterruptedException{
		Reporter.log("Locating the element with locator [" + "//*[@id=\"passwordNext\"]/div[2]" + "]", true);
		WebElement loginButton = driver.findElement(By.xpath("//span[text()='Next']"));
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
	}

}
