import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_ITestSuiteListener {

	@Test(dataProvider = "numbers", dataProviderClass = testdata.CalculatorTestData.class)
	public void veritySumForNegative(String num1, String num2, String sum) {
		Assert.assertEquals(Integer.parseInt(sum),
				Calculator.getInstance().addTwoNumbers(Integer.parseInt(num1), Integer.parseInt(num2)));
	}

	/**
	 * This test will be ignored as parameters are defined but not parameter tag or
	 * data provider tag
	 *
	 * @param num1
	 * @param num2
	 * @param sum
	 */
	@Test(dataProvider = "numbers", dataProviderClass = testdata.CalculatorTestData.class)
	public void veritySumForDouble(String num1, String num2, String sum) {
		Assert.assertEquals(Integer.parseInt(sum),
				Calculator.getInstance().addTwoNumbers(Integer.parseInt(num1), Integer.parseInt(num2)));
	}

}
