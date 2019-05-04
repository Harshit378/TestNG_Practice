package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import listeners.AutomationDriver;

public class Test_Popup {

	String baseURL = "http://output.jsbin.com/usidix/1";
	WebDriver driver;

	@BeforeClass
	public void launchAUT() {
		driver =  AutomationDriver.getDriver();
		driver.get(baseURL);
	}
	
	@Test
	public void acceptPopup() {
		WebElement goButton = driver.findElement(By.xpath("//input[@value='Go!']"));
		goButton.click();
		Reporter.log("popup text is " + driver.switchTo().alert().getText(), true);
		driver.switchTo().alert().accept();
	}
	
}
