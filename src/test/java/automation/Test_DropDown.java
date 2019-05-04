package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.AutomationDriver;
import utilities.CustomActions;

public class Test_DropDown {
	
	String baseURL = "http://demo.guru99.com/test/newtours/register.php";
	WebDriver driver;
	CustomActions customActions;
	
	@BeforeClass
	public void launchAUT() {
		driver =  AutomationDriver.getDriver();
		driver.get(baseURL);
		customActions = new CustomActions();
	}
	
	@Test
	public void radioAndCheckbox() {
		SoftAssert as = new SoftAssert();
		WebElement countrySelector = driver.findElement(By.xpath("//select[@name='country']"));
		Select countryDropdown = new Select(countrySelector);
		
		countryDropdown.selectByVisibleText("ANDORRA");
		as.assertEquals(countryDropdown.getFirstSelectedOption().getText(), "ANDORRA");
		Reporter.log("ANDORRA : " + countryDropdown.getFirstSelectedOption().getText(), true);
	
		
		countryDropdown.selectByIndex(10);
		as.assertEquals(countryDropdown.getFirstSelectedOption().getText(), "ARUBA");
		Reporter.log("ARUBA : " + countryDropdown.getFirstSelectedOption().getText(), true);
		
		countryDropdown.selectByValue("COLOMBIA");
		as.assertEquals(countryDropdown.getFirstSelectedOption().getText(), "COLOMBIA");
		Reporter.log("COLOMBIA : " + countryDropdown.getFirstSelectedOption().getText(), true);
		
		countryDropdown.getOptions().stream().forEach(element -> {System.out.println(element.getText());});
		
		as.assertAll();
	}

}
