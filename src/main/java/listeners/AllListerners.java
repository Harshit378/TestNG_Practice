package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class AllListerners implements IInvokedMethodListener, ITestListener, ISuiteListener{
	
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		  if(testResult.getStatus() == ITestResult.SUCCESS) {
			  Reporter.log("---------------------------------", true);
			  Reporter.log("Executed Method: [" + method.getTestMethod().getMethodName() + "] in test Class: [" + method.getClass().getName() + "]"
					   + "with Result: [SUCCESS]", true);
		  } else if (testResult.getStatus() == ITestResult.FAILURE){
			  Reporter.log("---------------------------------", true);
			  Reporter.log("Executed Method: [" + method.getTestMethod().getMethodName() + "] in test Class: [" + method.getClass().getName() + "]"
					   + "with Result: [FAILED]", true);
		  }
	}

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		Reporter.log("---------------------------------", true);
		Reporter.log("Executing Method: [" + method.getTestMethod().getMethodName() + "] in test Class: [" + method.getClass().getName() + "]", true);		
	}
	
	public void onFinish(ITestContext testResult) {
		Reporter.log("-------------------------------------------", true);
		Reporter.log("Test Finished [" + testResult.getName() + "]", true);
	}

	/**
	 * Runs before the <test> tag in XML file
	 */
	public void onStart(ITestContext testResult) {
		Reporter.log("-------------------------------------------", true);
		Reporter.log("Test Started [" + testResult.getName() + "]", true);
		ITestNGMethod[] methods = testResult.getAllTestMethods();
		Reporter.log("Below methods will be executed", true);		
		for (ITestNGMethod method : methods) {
			Reporter.log(method.getMethodName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult testResult) {
		Reporter.log("Test Failed [" + testResult.getName() + "]", true);
	}

	public void onTestSkipped(ITestResult testResult) {
		Reporter.log("Test Skipped [" + testResult.getName() + "]", true);
	}

	public void onTestStart(ITestResult testResult) {
		Reporter.log("-------------------------------------------", true);
		Reporter.log("Starting the test [" + testResult.getName() + "]", true);		
	}

	public void onTestSuccess(ITestResult testResult) {
		Reporter.log("Test Success [" + testResult.getName() + "]", true);
	}
	
	public void onFinish(ISuite arg0) {
		Reporter.log("------------------------------------------------", true);
		Reporter.log("Terminating the test suite [" + arg0.getName() + "]", true);
		Reporter.log("------------------------------------------------", true);
	}

	public void onStart(ISuite arg0) {
		Reporter.log("------------------------------------------------", true);
		Reporter.log("Starting the test suite [" + arg0.getName() + "]", true);
		Reporter.log("------------------------------------------------", true);
	}

}
