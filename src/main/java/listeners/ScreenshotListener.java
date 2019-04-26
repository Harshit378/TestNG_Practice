package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

	String filePath = "C:\\Users\\E076585\\Learning\\testng\\src\\main\\resources\\images\\";
	String currentTestMethodName;

	public void getScreenshot() {
		TakesScreenshot scrShot = ((TakesScreenshot) AutomationDriver.getDriver());
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filePath + currentTestMethodName + ".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext arg0) {
		this.currentTestMethodName = System.currentTimeMillis() + arg0.getName() + "_end";
		getScreenshot();
	}

	public void onStart(ITestContext arg0) {
		File destination = new File(filePath);
		try {
			FileUtils.cleanDirectory(destination);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	public void onTestFailure(ITestResult arg0) {
		this.currentTestMethodName = System.currentTimeMillis() + arg0.getName() + "_end";
		getScreenshot();
	}

	public void onTestSkipped(ITestResult arg0) {
		this.currentTestMethodName = System.currentTimeMillis() + arg0.getName() + "_end";
		getScreenshot();
	}

	public void onTestStart(ITestResult arg0) {
		this.currentTestMethodName = System.currentTimeMillis() + arg0.getName() + "_start";
		getScreenshot();
	}

	public void onTestSuccess(ITestResult arg0) {
		this.currentTestMethodName = System.currentTimeMillis() + arg0.getName() + "_end";
		getScreenshot();
	}

}