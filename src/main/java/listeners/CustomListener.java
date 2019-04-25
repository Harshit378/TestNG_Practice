package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListener implements IInvokedMethodListener{

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		  if(testResult.getStatus() == ITestResult.SUCCESS) {
			  System.out.println("---------------------------------");
			  System.out.println("Executed Method: [" + method.getTestMethod().getMethodName() + "] in test Class: [" + method.getClass().getName() + "]"
					   + "with Result: [SUCCESS]");
		  } else if (testResult.getStatus() == ITestResult.FAILURE){
			  System.out.println("---------------------------------");
			  System.out.println("Executed Method: [" + method.getTestMethod().getMethodName() + "] in test Class: [" + method.getClass().getName() + "]"
					   + "with Result: [FAILED]");
		  }
	}

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("---------------------------------");
		System.out.println("Executing Method: [" + method.getTestMethod().getMethodName() + "] in test Class: [" + method.getClass().getName() + "]");		
	}
	
}
