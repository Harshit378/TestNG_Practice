import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_DataProviders {

    @DataProvider(name = "numbers")
    public Object[][] getNumbers() {
        return new Object[][]{
                {"2", "4", "6"},
                {"-8", "-9", "-17"},
                {"10", "25", "35"},
        };
    }

    @Test(dataProvider = "numbers")
    public void veritySumForNegative(String num1, String num2, String sum) {
        System.out.println("This is test method --> Test_ParallelOne --> veritySumForNegative " + Test_Annotations.class.getName());
        Assert.assertEquals(Integer.parseInt(sum), Calculator.getInstance().addTwoNumbers(Integer.parseInt(num1), Integer.parseInt(num2)));
    }

    /**
     * This test will be ignored as parameters are defined but not parameter tag or dataprovider tag
     *
     * @param num1
     * @param num2
     * @param sum
     */
    @Test(dataProvider = "numbers")
    public void veritySumForDouble(String num1, String num2, String sum) {
        System.out.println("This is test method --> Test_ParallelOne --> veritySumForDouble" + Test_Annotations.class.getName());
        Assert.assertEquals(Integer.parseInt(sum), Calculator.getInstance().addTwoNumbers(Integer.parseInt(num1), Integer.parseInt(num2)));
    }

}
