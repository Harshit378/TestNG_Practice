package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.AutomationDriver;
import utilities.CustomActions;

public class Test_RadioCheckbox {
	
	String baseURL = "http://demo.guru99.com/test/radio.html";
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
		WebElement Option2 = driver.findElement(By.cssSelector("#vfb-7-2"));
		Option2.click();
		boolean isRadioButtonSelected = Option2.isSelected();
		Reporter.log("isRadioButtonSelected : " + isRadioButtonSelected, true);
		SoftAssert as = new SoftAssert();
		as.assertEquals(isRadioButtonSelected, true);
		
		WebElement Checkbox2 = driver.findElement(By.cssSelector("#vfb-6-1"));
		customActions.selectCheckbox(Checkbox2);
		boolean isCheckboxSelected = Checkbox2.isSelected();
		Reporter.log("isCheckboxSelected : " + isCheckboxSelected, true);
		as.assertEquals(isCheckboxSelected, true);
		
		as.assertAll();
	}

}
