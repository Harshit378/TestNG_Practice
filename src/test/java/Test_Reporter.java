import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Reporter {

	@BeforeClass
	public void setUp() {
		Reporter.log("Before Class --> " + Test_Annotations.class.getName());
	}

	@Test(priority = 1, groups = { "print" })
	public void verifyTestMethod() {
		Reporter.log("This is test method --> verifyTestMethod" + Test_Annotations.class.getName(), true);
	}

	@Test(priority = 3, groups = { "sum", "print" })
	public void veritySumForNegative() {
		Reporter.log("This is test method --> veritySumForNegative" + Test_Annotations.class.getName(), true);
		Assert.assertEquals(-15, Calculator.getInstance().addTwoNumbers(-5, -10));
	}

	@Test(priority = 2, groups = { "sum", "print" })
	public void veritySumForDouble() {
		Reporter.log("This is test method --> veritySumForDouble" + Test_Annotations.class.getName(), true);
		Assert.assertEquals(10.2, Calculator.getInstance().addTwoNumbers(5.4, 4.8));
	}

}
