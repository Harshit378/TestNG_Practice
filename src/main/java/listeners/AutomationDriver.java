package listeners;

import org.openqa.selenium.WebDriver;

public class AutomationDriver {

	private static WebDriver driver;
	private static AutomationDriver automationDriver;

	public static void setDriver(WebDriver driver) {
		AutomationDriver.driver = driver;
	}

	public static AutomationDriver getInstance() {
		if (automationDriver == null) {
			return new AutomationDriver();
		}
		return automationDriver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
