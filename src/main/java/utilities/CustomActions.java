package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import listeners.AutomationDriver;

public class CustomActions {

	WebDriverWait wait;

	public void clickWithJsExecutor(WebElement element) {
		((JavascriptExecutor) AutomationDriver.getDriver()).executeScript("arguments[0].click();", element);
	}

	public void waitForElementToAppear(By elementLocator) {
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
	}

	public void selectCheckbox(WebElement checkboxElement) {
		if (!checkboxElement.isSelected())
			checkboxElement.click();
		else
			Reporter.log("The checkbox is already selected", true);
	}

}
