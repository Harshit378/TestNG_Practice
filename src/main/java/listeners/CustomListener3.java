package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomListener3 implements ISuiteListener {
	
	public void onFinish(ISuite arg0) {
		System.out.println("------------------------------------------------");
		System.out.println("Terminating the test suite [" + arg0.getName() + "]");
		System.out.println("------------------------------------------------");
	}

	public void onStart(ISuite arg0) {
		System.out.println("------------------------------------------------");
		System.out.println("Starting the test suite [" + arg0.getName() + "]");
		System.out.println("------------------------------------------------");
	}

}
