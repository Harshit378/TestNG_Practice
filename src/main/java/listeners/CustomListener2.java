package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener2 implements ITestListener{

	public void onFinish(ITestContext testResult) {
		System.out.println("-------------------------------------------");
		System.out.println("Test Finished [" + testResult.getName() + "]");
	}

	/**
	 * Runs before the <test> tag in XML file
	 */
	public void onStart(ITestContext testResult) {
		System.out.println("-------------------------------------------");
		System.out.println("Test Started [" + testResult.getName() + "]");
		ITestNGMethod[] methods = testResult.getAllTestMethods();
		System.out.println("Below methods will be executed");		
		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult testResult) {
		System.out.println("Test Failed [" + testResult.getName() + "]");
	}

	public void onTestSkipped(ITestResult testResult) {
		System.out.println("Test Skipped [" + testResult.getName() + "]");
	}

	public void onTestStart(ITestResult testResult) {
		System.out.println("-------------------------------------------");
		System.out.println("Starting the test [" + testResult.getName() + "]");		
	}

	public void onTestSuccess(ITestResult testResult) {
		System.out.println("Test Success [" + testResult.getName() + "]");
	}
	
}
