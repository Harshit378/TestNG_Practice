package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.AutomationDriver;
import listeners.ScreenshotListener;
import utilities.CustomActions;

@Listeners(ScreenshotListener.class)
public class Test_DropDown extends LoadableComponent<Test_DropDown> {

	String baseURL = "http://demo.guru99.com/test/newtours/register.php";
	WebDriver driver;
	CustomActions customActions;

	@FindBy(xpath = "//select[@name='country']")
	private static WebElement countrySelector;
	
	@FindBy(xpath = "//select[@name='123456']")
	private static WebElement countrySelector1;

	@BeforeClass
	public void launchAUT() {
		driver = AutomationDriver.getDriver();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		driver.get(baseURL);
		customActions = new CustomActions();		
	}

	@Test
	public void radioAndCheckbox() {
		countrySelector1.clear();
		SoftAssert as = new SoftAssert();
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

		countryDropdown.getOptions().stream().forEach(element -> {
			System.out.println(element.getText());
		});
		
		as.assertAll();		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

}
