package testdata;

import org.testng.annotations.DataProvider;

public class CalculatorTestData {

	@DataProvider(name = "numbers")
	public Object[][] getNumbers() {
		return new Object[][] { { "2", "4", "8" }, { "-8", "-9", "-17" }, { "10", "25", "35" }, };
	}
	
}
